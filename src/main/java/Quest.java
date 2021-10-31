import java.util.*;

/**
 * Represents a quest in the game.
 * The narrative of the game is driven by quests.
 */
public abstract class Quest {

    private String name;
    private ArrayList<String> rewardItems = new ArrayList<>();

    private int completion;

    /**
     * Gets the name of the Quest.
     * @return the name of the Quest
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the list of rewards of the Quest.
     * @return an ArrayList containing the rewards of the Quest
     */
    public ArrayList<String> getRewards() {
        return this.rewardItems;
    }

    /**
     * Check whether the Quest has been completed by the player.
     * @return whether the Quest has been completed
     */
    public boolean isComplete() {
        return this.completion == 2;
    }

    /**
     * Mark the Quest as completed by the player.
     */
    public void toggleComplete() {
        this.completion = 2;
    }

    /**
     * Check whether the Quest has been accepted by the player.
     * @return whether the Quest has been accepted
     */
    public boolean isAccepted() {
        return this.completion == 1;
    }

    /**
     * Mark the Quest as accepted by the player.
     */
    public void toggleAccepted() {
        this.completion = 1;
    }

    /**
     * Get the completion state of the quest, represented as an integer.
     * 0 = not accepted (default), 1 = accepted but not completed, 2 = completed.
     * @return int representing completion state
     */
    public int getCompletion(){
        return completion;
    }

    /**
     * Check if the conditions of the quest have been met by the player.
     * @param player the player character
     * @return whether the quest conditions are fulfilled
     */
    public abstract boolean checkDone(PlayerCharacter player);

}
