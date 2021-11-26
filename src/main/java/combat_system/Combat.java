package combat_system;
import GUI.MainFrame;
import characters.*;
import com.sun.tools.javac.Main;

import java.util.*;
import java.util.Scanner;

/**
 * Creates an instance of combat that will run until completion. If the player dies, or the foes all die.
 */
public class Combat {
    private int round = 1;
    private int foes;
    private boolean player_alive = true;
    private ArrayList<GameCharacter> participants;
    private ArrayList<CharacterInventoryFacade> people;
    private TreeMap<Double, GameCharacter> turnorder = new TreeMap<>();
    public boolean attack, ability, inventory, secondStage;

    public Combat(ArrayList<CharacterInventoryFacade> people) {
        this.participants = new ArrayList<GameCharacter>();
        for (CharacterInventoryFacade person: people) {
            this.participants.add(person.getCharacter().getCharacter());
        }
        this.people = people;
        this.foes = participants.size()-1;
    }
    /**
     * Applies a status effect if there is currently no status effect of that name applied or if there is a status
     * effect of that name but its duration is lower than the new application's.
     * @param target a reference to the target of the status effect
     * @param status the status effect to apply
     * @param duration the duration of the status effect to apply
     */
    public void statusEffect(GameCharacter target, StatusEffect status, int duration) {
        if(target.getStatusEffects().get(status) == null || target.getStatusEffects().get(status)
                < duration) {
            target.setStatusEffect(status, duration);
        }
    }
    /**
     * Increments the round and goes through each status effect for all participants and decrements their duration
     */
    public void endRound() {
        this.round += 1;
        for (GameCharacter participant : this.participants) {
            for(Map.Entry<StatusEffect, Integer> entry : participant.getStatusEffects().entrySet()) {
                participant.setStatusEffect(entry.getKey(), entry.getValue()-1);
            }
        }
    }

    /**
     * Used at the end of combat to clear all participants' status effects.
     * Duration 0 causes the status to be removed, see GameCharacter.setStatusEffect for more information
     */
    public void clearStatus() {
        for (GameCharacter participant : this.participants) {
            for (Map.Entry<StatusEffect, Integer> entry : participant.getStatusEffects().entrySet()) {
                participant.setStatusEffect(entry.getKey(), 0);
            }
        }

    }

    /**
     * Calculates if an attack hits and the amount of damage it deals
     * @return the string description of damage being delt
     */
    public String damage(int toHit, GameCharacter target, GameCharacter attacker) {
        if(toHit >= target.getArmor().getDefense()) {
            int health_remaining = target.getCurrentHealth()-attacker.getWeapon().getDamage();
            target.setCurrentHealth(health_remaining);
            if(health_remaining <= 0) {
                if(target instanceof NonPlayerCharacter) {
                    this.foes -= 1;
                    return "You strike the killing blow against " + target.getName();
                }
                else {
                    this.player_alive = false;
                    return "You are dead!";
                }
            }

            return "The attack hits, dealing " + attacker.getWeapon().getDamage() + " damage!";
        }
        else {
            return "The attack misses!";
        }
    }

    public void attack(MainFrame frame) {
        if(!secondStage) {
            ability = inventory = false;
            attack = true;
            StringBuilder targets = new StringBuilder("Who would you like to attack?");
            frame.displayCombatInput("Select Target");
            for (GameCharacter participant: participants) {
                if (participant instanceof NonPlayerCharacter) {
                    targets.append("\n").append(participant.getName());
                }
            }
            frame.displayCombatText(targets.toString());
            //end turn
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    public void defend(MainFrame frame) {
        if(!secondStage) {
            attack = ability = inventory = false;
            frame.displayCombatText("You enter a defensive stance");
            //end turn
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    public void ability(MainFrame frame) {
        if(!secondStage) {
            attack = inventory = false;
            ability = true;
            StringBuilder abilities = new StringBuilder("What ability would you like to use?");
            for(Ability ability: findPlayer().getCharacter().getCharacter().getAbilities()) {
                abilities.append("\n").append(ability.getName());
            }
            frame.displayCombatText(abilities.toString());
            frame.displayCombatInput("Select Ability");
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    public void inventory(MainFrame frame) {
        if(!secondStage) {
            ability = attack = false;
            inventory = true;
            frame.displayCombatText(findPlayer().getInventory());
            frame.displayCombatInput("Select Item");
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    public int rollAttack() {
        Random r = new Random();
        return r.nextInt(20);
    }
    /**
     * This method determines if a character is an NPC or a player and then proceeds to have them take a turn.
     * @param participant the GameCharacter who is taking the turn
     */
    public String takeTurn(GameCharacter participant) {
        Random r = new Random();
        if(participant instanceof NonPlayerCharacter) {
            GameCharacter target = findPlayer().getCharacter().getCharacter();
            if(r.nextBoolean()) {
               return participant.getName()+" enters a defensive stance" + printBorder();
            }
            else {
                return participant.getName()+" makes an attack against you!" + "\n" +
                        "It deals:" + damage(r.nextInt(20), target, participant) + printBorder();
            }
        }
        else {
            boolean valid_input = false;
            while(!valid_input) {
                Scanner sc = new Scanner(System.in);
                System.out.println("It is your turn, what do you do?");
                System.out.println("Attack");
                System.out.println("Defend");
                String user_input = sc.nextLine();
                if(user_input.equals("Attack")) {
                    HashMap<String, NonPlayerCharacter> npc_names = new HashMap<>();
                    System.out.print("The remaining enemies are:");
                    for(NonPlayerCharacter npc : findAliveNpcs()) {
                        System.out.println(npc.getName());
                        npc_names.put(npc.getName(), npc);
                    }
                    System.out.println("Which will you attack?");
                    boolean valid_attack = false;
                    while(!valid_attack) {
                        String attack_input = sc.nextLine();
                        if(npc_names.containsKey(attack_input)) {
                            System.out.println(damage(r.nextInt(20), npc_names.get(attack_input), participant));
                            valid_attack = true;
                        }
                        else {
                            System.out.println("Please enter a valid name for the attack");
                        }

                    }
                    valid_input = true;
                }
                else if(user_input.equals("Defend")) {
                    System.out.println("You enter a defensive stance");
                    valid_input = true;
                }
                else{
                    System.out.println("Not a valid input, try again");
                }
                printBorder();
            }
        }
        return "nothing";
    }

    /**
     * This method finds the player character and returns them from amongst participants
     * @return the player character
     */
    public CharacterInventoryFacade findPlayer() {
        for(CharacterInventoryFacade player : this.people) {
            if(player.getCharacter().getCharacter() instanceof PlayerCharacter) {
                return player;
            }
        }
        return null; // this should never happen
    }

    /**
     * Finds all alive npcs. If there are none, it will return an empty arraylist
     * @return an arraylist of all alive npcs.
     */
    public ArrayList<NonPlayerCharacter> findAliveNpcs() {
        ArrayList<NonPlayerCharacter> npc_list = new ArrayList<>();
        for(GameCharacter npc : this.participants) {
            if(npc instanceof NonPlayerCharacter) {
                npc_list.add((NonPlayerCharacter) npc);
            }
        }
        return npc_list;
    }

    /**
     * Prints a border that makes the console easier to read for the user
     */
    public String printBorder() {
        return "------------------------------------------------";
    }

    /**
     * Prints the current turn order.
     * In the future abilities may change people's place in the turn order
     */
    public String printTurnOrder() {
        int turn = 1;
        StringBuilder turnOrder = new StringBuilder("Current Turn Order:");
        for(Map.Entry<Double, GameCharacter> partcipant : this.turnorder.entrySet()) {
            turnOrder.append("\n").append(turn).append(". ").append(partcipant.getValue().getName());
            turn += 1;
        }
        turnOrder.append(printBorder());
        return turnOrder.toString();
    }

    /**
     * Creates the combat loop, only ends when there is all foes are dead or if the player is dead
     * Turn order is determined randomly
     * Each round it calls the turn for each player
     * At the end of each round (which is determined by one iteration through the while loop) all statuses decrement
     * At the end of the combat it will clear all statuses
     */
    public void combatLoop() {
        boolean combat = false;
        if(this.participants.size() > 1) {
            combat = true;
            Random rand = new Random();
            for (GameCharacter participant : this.participants) {
                this.turnorder.put(rand.nextDouble(), participant);
            }
            System.out.println("Combat begins");
        }
        else {
            System.out.println("There is no one to attack here");
        }
        outerloop:
        while (combat) {
            printTurnOrder();
            for (Map.Entry<Double, GameCharacter> partcipant : this.turnorder.entrySet()) {
                if (partcipant.getValue().getCurrentHealth() > 0) {
                    takeTurn(partcipant.getValue());
                    if (!this.player_alive||this.foes==0) {
                        break outerloop;
                    }
                }
            }
            endRound();
            System.out.println("The round has ended, the next round is: " + this.round);

        }
        clearStatus();
    }
}
