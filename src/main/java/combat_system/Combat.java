package combat_system;
import GUI.MainFrame;
import characters.*;
import constants.Constants;
import constants.Observer;

import java.util.*;

/**
 * Creates an instance of combat that will run until completion. If the player dies, or the foes all die.
 */
public class Combat {
    private int round = 1;
    private int currentTurn;
    private boolean playerAlive = true;
    private ArrayList<GameCharacter> participants;
    private ArrayList<CharacterInventoryFacade> people;
    private TreeMap<Double, GameCharacter> turnorder = new TreeMap<>();
    public boolean attack, ability, inventory, secondStage, endTurn;
    private List<Observer> observers;

    private CharacterStatusEffectFacade effectFacade = new CharacterStatusEffectFacade();

    public Combat(ArrayList<CharacterInventoryFacade> people, List<Observer> observers) {
        this.participants = new ArrayList<>();
        for (CharacterInventoryFacade person: people) {
            this.participants.add(person.getCharacter().getCharacter());
        }
        this.people = people;
        this.endTurn = false;
        this.observers = observers;
    }

    /**
     * Increments the round and applies status effect to each character
     * @return toReturn returns a string to be displayed of all npcs killed by status effects
     */
    public String endRound() {
        StringBuilder toReturn = new StringBuilder();
        this.round += 1;
        boolean first = true;
        for(GameCharacter npc : effectFacade.process(this.participants)) {
            if(first) {
                toReturn.append(npc.getName());
                first = false;
            }
            else {
                toReturn.append(" and ").append(npc.getName());
            }
        }
        if(!toReturn.toString().equals("")) {
            toReturn.append(" died of status effects");
        }
        return toReturn.toString();
    }

    /**
     * Used at the end of combat to clear all participants' status effects.
     * Duration 0 causes the status to be removed, see GameCharacter.setStatusEffect for more information
     */
    public void clearStatus() {
        effectFacade.clear(participants);
    }

    /**
     * Calculates if an attack hits and the amount of damage it deals
     * @return the string description of damage being dealt
     */
    public String damage(int toHit, GameCharacter target, GameCharacter attacker) {
        if (toHit >= target.getArmorDefense()) {
            int dealtDamage = attacker.getWeaponDamage();
            int healthRemaining = target.getCurrentHealth()-dealtDamage;
            target.setCurrentHealth(healthRemaining);
            if (healthRemaining <= 0) {
                if (target instanceof NonPlayerCharacter) {
                    for (Observer observer: observers){
                        observer.update(target);
                    }
                    return "You strike the killing blow against " + target.getName();
                }
                else {
                    this.playerAlive = false;
                    return "You are dead!";
                }
            }

            return "The attack hits, dealing " + dealtDamage + " damage!";
        }
        else {
            return "The attack misses!";
        }
    }

    /**
     * Controls the display of an attack
     * Displays the available targets
     * @param frame the GUI
     */
    public void attack(MainFrame frame) {
        if (!secondStage) {
            ability = inventory = false;
            attack = true;
            StringBuilder targets = new StringBuilder("Who would you like to attack?");
            frame.displayCombatInput("Select Target");
            for (NonPlayerCharacter npc: findAliveNpcs()) {
                targets.append("\n").append(npc.getName());
            }
            frame.displayCombatText(targets.toString());
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    /**
     * Controls the display of the defensive stance
     * @param frame the GUI
     */
    public void defend(MainFrame frame) {
        if (!secondStage) {
            attack = ability = inventory = false;
            frame.displayCombatText("You enter a defensive stance");
            endTurn = true;
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    /**
     * Controls the display of abilities
     * @param frame the GUI
     */
    public void ability(MainFrame frame) {
        if (findPlayer().getCharacter().getCharacter().getAbilities().size() == 0) {
            frame.displayCombatText("You have no abilities");
        }
        else if (!secondStage) {
            attack = inventory = false;
            ability = true;
            StringBuilder abilities = new StringBuilder("What ability would you like to use?");
            for (Ability ability: findPlayer().getCharacter().getCharacter().getAbilities()) {
                abilities.append("\n").append(ability.getName());
            }
            frame.displayCombatText(abilities.toString());
            frame.displayCombatInput("Select Ability");
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    /**
     * Controls the display of inventory items
     * @param frame the GUI
     */
    public void inventory(MainFrame frame) {
        if (!secondStage) {
            ability = attack = false;
            if (findPlayer().getInventory().equals("")) {
                frame.displayCombatText("You have no items");
            }
            else {
                inventory = true;
                frame.displayCombatText(findPlayer().getInventory());
                frame.displayCombatText("Which item would you like to use?");
                frame.displayCombatInput("Select Item");
            }
        }
        else {
            frame.displayCombatText("Please select a target for your ability");
        }
    }

    /**
     * Rolls an attack to be compared to a defense stat
     * @param attacker the game character that is making the attack
     * @return an integer that will be used as the "to hit"
     */
    public int rollAttack(GameCharacter attacker) {
        Random r = new Random();
        return r.nextInt(20)+attacker.getWeaponDamage();
    }

    /**
     * This method takes a turn for a npc
     * want to add percents for character behavior to attack or use abilities or defend
     * @param npc the GameCharacter who is taking the turn
     */
    public String takeTurn(NonPlayerCharacter npc) {
        Random r = new Random();
        GameCharacter target = findPlayer().getCharacter().getCharacter();
        if (npc.getCurrentHealth() <= 0) {
            return npc.getName() + " lies bleeding on the floor. They do not take a turn";
        }
        else if (r.nextBoolean()) {
            Object[] abilities = Constants.ABILITY_LIST.values().toArray();
            Ability ability = (Ability) abilities[r.nextInt(abilities.length)];
            for (StatusEffect effect : ability.getEffects()) {
                this.applyEffect(target, effect, ability.getDuration());
            }
            return ability.getCombatText(npc.getName(), target.getName());
        }
        else {
            return npc.getName() + " makes an attack against you!" + "\n" + damage(rollAttack(npc), target, npc);
        }
    }

    /**
     * This method finds the player character and returns them from amongst participants
     * @return the player character
     */
    public CharacterInventoryFacade findPlayer() {
        for (CharacterInventoryFacade player : this.people) {
            if (player.getCharacter().getCharacter() instanceof PlayerCharacter) {
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
        ArrayList<NonPlayerCharacter> npcList = new ArrayList<>();
        for (GameCharacter npc : this.participants) {
            if (npc instanceof NonPlayerCharacter) {
                if (npc.getCurrentHealth() > 0) {
                    npcList.add((NonPlayerCharacter) npc);
                }
            }
        }
        return npcList;
    }

    /**
     * Prints a border that makes the console easier to read for the user
     */
    public String printBorder() {
        return "-------------------";
    }

    /**
     * Prints the current turn order.
     * In the future abilities may change people's place in the turn order
     */
    public String turnOrder() {
        int turn = 1;
        StringBuilder turnOrder = new StringBuilder("Current Turn Order:");
        for (Map.Entry<Double, GameCharacter> participant : this.turnorder.entrySet()) {
            turnOrder.append("\n").append(turn).append(". ").append(participant.getValue().getName());
            turn += 1;
        }
        return turnOrder.toString();
    }

    /**
     * This is the main driver of combat
     * We update health everytime a new turn is started
     * If there are no foes remaining we end combat
     * If the player is dead we give the game over screen
     * Otherwise we find where we are in the turn order and start the next appropriate turn, npc or player
     */
    public void nextTurn(MainFrame frame) {
        frame.setHpLabel();
        frame.displayCombatText(printBorder());
        if (findAliveNpcs().size() == 0) {
            frame.getSceneManager().removeDead(frame.getCurrentScene());
            clearStatus();
            frame.exitCombatFrame();
        }
        else if (!playerAlive) {
            frame.gameOver();
        }
        else {
            if (currentTurn == turnorder.size()) {
                frame.displayCombatText("End of round " + round);
                frame.displayCombatText(printBorder());
                String deadNpcs = endRound();
                if(!deadNpcs.equals("")) {
                    frame.displayCombatText(deadNpcs);
                }
                currentTurn = 0;
            }
            GameCharacter person = (GameCharacter) turnorder.values().toArray()[currentTurn];
            currentTurn += 1;
            if (person instanceof NonPlayerCharacter) {
                frame.displayCombatText(takeTurn((NonPlayerCharacter) person));
                nextTurn(frame);
            }
            else {
                frame.displayCombatText("It is your turn");
            }

        }
    }

    /**
     * Starts combat by calling the first turn
     * Turn order is determined randomly
     */
    public void startCombat(MainFrame frame) {
        Random rand = new Random();
        for (GameCharacter participant : this.participants) {
            this.turnorder.put(rand.nextDouble(), participant);
        }
        frame.displayCombatText(turnOrder());
        nextTurn(frame);
    }

    /**
     * Applies an effect to a target, from an ability
     * @param target the target that will suffer the effect
     * @param effect what the effect does to the target
     * @param duration the duration of the effect
     */
    public void applyEffect(GameCharacter target, StatusEffect effect, int duration) {
        this.effectFacade.apply(target, effect, duration);
    }

}
