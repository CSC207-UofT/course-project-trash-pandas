package combat_system;
import characters.GameCharacter;
import characters.NonPlayerCharacter;
import characters.PlayerCharacter;

import java.util.*;
import java.util.Scanner;

/**
 * Creates an instance of combat that will run until completion. If the player dies, or the foes all die.
 */
public class Combat {
    private int round = 0;
    private int foes = 0;
    private boolean player_alive = true;
    private ArrayList<GameCharacter> participants = new ArrayList<>();
    private TreeMap<Double, GameCharacter> turnorder = new TreeMap<Double, GameCharacter>();

    Combat(ArrayList<GameCharacter> participants) {
        this.participants = participants;
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
                }
                else {
                    this.player_alive = false;
                }
            }

            return "The attack hits, dealing " + attacker.getWeapon().getDamage() + " damage!";
        }
        else {
            return "The attack misses!";
        }
    }

    /**
     * This method determines if a character is an NPC or a player and then proceeds to have them take a turn.
     * @param participant the GameCharacter who is taking the turn
     */
    public void take_turn(GameCharacter participant) {
        Random r = new Random();
        if(participant instanceof NonPlayerCharacter) {
            PlayerCharacter target = find_player();
            if(r.nextBoolean()) {
                System.out.println(participant.getName()+" enters a defensive stance");
            }
            else {
                System.out.println(participant.getName()+" makes an attack against you!");
                System.out.println(damage(r.nextInt(20), target, participant));
            }
        }
        else {
            Scanner sc = new Scanner(System.in);
            boolean valid_input = false;
            while(!valid_input) {
                System.out.println("It is your turn, what do you do?");
                System.out.println("Attack");
                System.out.println("Defend");
                if(sc.nextLine().equals("Attack")) {
                    HashMap<String, NonPlayerCharacter> npc_names = new HashMap<>();
                    System.out.print("The remaining enemies are:");
                    for(NonPlayerCharacter npc : find_alive_npcs()) {
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
                if(sc.nextLine().equals("Defend")) {
                    System.out.println("You enter a defensive stance");
                    valid_input = true;
                }
                else{
                    System.out.println("Not a valid input, try again");
                }

            }
        }
    }

    /**
     * This method finds the player character and returns them from amongst participants
     * @return the player character
     */
    public PlayerCharacter find_player() {
        for(GameCharacter player : this.participants) {
            if(player instanceof PlayerCharacter) { // Is this needed?
                return (PlayerCharacter) player;
            }
        }
        return null; // this should never happen
    }

    /**
     * Finds all allive npcs. If there are none, it will return an empty arraylist
     * @return an arraylist of all alive npcs.
     */
    public ArrayList<NonPlayerCharacter> find_alive_npcs() {
        ArrayList<NonPlayerCharacter> npc_list = new ArrayList<>();
        for(GameCharacter npc : this.participants) {
            if(npc instanceof NonPlayerCharacter) {
                npc_list.add((NonPlayerCharacter) npc);
            }
        }
        return npc_list;
    }

    /**
     * Creates the combat loop, only ends when there is all foes are dead or if the player is dead
     * Turn order is determined randomly
     * Each round it calls the turn for each player
     * At the end of each round (which is determined by one iteration through the while loop) all statuses decrement
     * At the end of the combat it will clear all statuses
     */
    public void combatLoop() {
        boolean combat = true;
        Random rand = new Random();
        for (GameCharacter participant : this.participants) {
            this.turnorder.put(rand.nextDouble(), participant);
        }

        while (combat) {
            for (Map.Entry<Double, GameCharacter> partcipant : this.turnorder.entrySet()) {
                if(this.foes == 0 || !this.player_alive) {
                    combat = false;
                }
                else {
                    if (partcipant.getValue().getCurrentHealth() > 0) {
                        take_turn(partcipant.getValue());
                    }
                }
            }
            endRound();

        }
        clearStatus();
    }
}
