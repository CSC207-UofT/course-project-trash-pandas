package quest_system;

import characters.CharacterInventoryFacade;
import characters.ItemCheckable;
import items.QuestItem;
import quest_system.Quest;
import characters.PlayerCharacter;

/**
 * Represents a fetch quest in the game.
 */
public class FetchQuest extends Quest{

    private QuestItem goalItem;

    /**
     * Constructor for the quest_system.FetchQuest class.
     * @param goalItem the item to be fetched
     */
    public FetchQuest(QuestItem goalItem) {
        this.goalItem = goalItem;
    }

    /**
     * Checks if the conditions of the quest have been met by the player.
     * The inventory must contain the QuestItem.
     * @param player the player character
     * @return whether the quest conditions are fulfilled
     */
    @Override
    public boolean checkDone(ItemCheckable player) {
        return player.checkItem(goalItem.getName());
    }

}
