package quest_system;

import characters.ItemCheckable;
import items.QuestItem;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a fetch quest in the game.
 */
public class FetchQuest extends Quest{

    private Set<QuestItem> goalItems = new HashSet<>();

    /**
     * Constructor for the quest_system.FetchQuest class.
     * @param goalItems the items to be fetched
     */
    public FetchQuest(Set<QuestItem> goalItems) {
        this.goalItems.addAll(goalItems);
    }

    /**
     * Checks if the conditions of the quest have been met by the player.
     * The inventory must contain the QuestItem.
     */
    @Override
    public void checkDone() {
        if(this.goalItems.isEmpty() && this.isAccepted()){
            this.toggleComplete();
        }
    }

    @Override
    public void update(Object args) {
        if (this.goalItems.contains(args)){
            this.goalItems.remove(((QuestItem)args));
        }
        this.checkDone();
    }

}
