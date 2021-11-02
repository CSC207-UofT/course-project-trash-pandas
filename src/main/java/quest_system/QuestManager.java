package quest_system;

import characters.GameCharacter;
import quest_system.CompleteQuest;
import quest_system.Quest;

import java.util.*;

/**
 * Manages and tracks all quests in the game.
 */

public class QuestManager {

    CompleteQuest c = new CompleteQuest();

    private HashMap<String, Quest> quests = new HashMap<>();

    /**
     * Adds a quest_system.Quest to the list of quests.
     * @param newQuest the quest_system.Quest to be added
     */
    public void addQuest(Quest newQuest) {
        quests.put(newQuest.getName(), newQuest);
    }

    /**
     * Gets a quest_system.Quest by name.
     * @param name the name of the quest_system.Quest to be retrieved
     * @return the quest_system.Quest with the specified name, or null if none exist
     */
    public Quest getQuest(String name) {
        return quests.get(name);
    }



    /**
     * Asserts that quest_system.Quest is not accepted yet and marks quest as accepted.
     * @param quest the quest_system.Quest to be accepted
     */
    public void accept(Quest quest) {
        assert !quest.isAccepted();

        quest.toggleAccepted();
    }

    /**
     * Asserts a quest_system.Quest is not yet completed, rewards the player and marks quest as completed.
     * @param player the player Character completing the quest_system.Quest
     * @param quest the quest_system.Quest to be completed
     */
    public void complete(GameCharacter player, Quest quest) {
        assert !quest.isComplete();

        for (String item : quest.getRewards()) {
            player.addItem(item);
        }

        quest.toggleComplete();
    }
}
