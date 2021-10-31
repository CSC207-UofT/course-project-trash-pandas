/**
 * Represents a fetch quest in the game.
 */
public class FetchQuest extends Quest {

    private String goalItem;

    /**
     * Constructor for the FetchQuest class.
     * @param goalItem the item to be fetched
     */
    public FetchQuest(String goalItem) {
        this.goalItem = goalItem;
    }

    /**
     * Checks if the conditions of the quest have been met by the player.
     * The player must possess the item to be fetched in their inventory.
     * @param player the player character
     * @return whether the quest conditions are fulfilled
     */
    public boolean checkDone(PlayerCharacter player) {
        return player.checkItem(this.goalItem);
    }

}
