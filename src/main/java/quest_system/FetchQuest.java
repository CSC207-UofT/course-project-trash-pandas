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
    public FetchQuest(String name, Set<QuestItem> goalItems) {
        super(name, 0);
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

    /**
     * removes args from the set goalItems
     * @param args QuestItems that would be removed from goalItems if it's in the set
     */
    @Override
    public void update(Object args) {
        if (this.goalItems.contains((QuestItem) args)){
            this.goalItems.remove(((QuestItem)args));
        }
    }

}
