package quest_system;

import characters.ItemCheckable;
import constants.Observer;

import java.util.*;

/**
 * Represents a quest in the game.
 * The narrative of the game is driven by quests.
 */
public abstract class Quest implements Observer {

    private String name;
    private ArrayList<String> rewardItems = new ArrayList<>();

    private int completion;

    /**
     * creates an instance of Quest
     * @param name the name of the quest
     * @param completion an int representing the completion progress of the quest
     */
    public Quest (String name, int completion){
        this.name = name;
        this.completion = 0;
    }

    /**
     * Gets the name of the quest_system.Quest.
     * @return the name of the quest_system.Quest
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the list of rewards of the quest_system.Quest.
     * @return an ArrayList containing the rewards of the quest_system.Quest
     */
    public ArrayList<String> getRewards() {
        return this.rewardItems;
    }

    public void addReward(String item){
        this.rewardItems.add(item);
    }
    /**
     * Checks whether the quest_system.Quest has been completed by the player.
     * @return whether the quest_system.Quest has been completed
     */
    public boolean isComplete() {
        return this.completion == 2;
    }

    /**
     * Marks the quest_system.Quest as completed by the player.
     */
    public void toggleComplete() {
        this.completion = 2;
    }

    /**
     * Checks whether the quest_system.Quest has been accepted by the player.
     * @return whether the quest_system.Quest has been accepted
     */
    public boolean isAccepted() {
        return this.completion == 1;
    }

    /**
     * Marks the quest_system.Quest as accepted by the player.
     */
    public void toggleAccepted() {
        this.completion = 1;
    }

    /**
     * Gets the completion state of the quest, represented as an integer.
     * 0 = not accepted (default), 1 = accepted but not completed, 2 = completed.
     * @return int representing completion state
     */
    public int getCompletion(){
        return completion;
    }

    /**
     * Checks if the conditions of the quest have been met by the player.
     */
    public abstract void checkDone();

    /**
     * removes requirements from the quest
     */
    public abstract void update(Object args);

}
