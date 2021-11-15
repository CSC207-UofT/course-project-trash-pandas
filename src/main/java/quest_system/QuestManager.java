package quest_system;

import characters.GameCharacter;
import org.json.simple.JSONObject;
import quest_system.CompleteQuest;
import quest_system.Quest;

import java.util.*;

/**
 * Manages and tracks all quests in the game.
 */

public class    QuestManager {

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
     * Mark a quest_system.Quest as completed and issue rewards.
     * @param player the player Character completing the quest_system.Quest
     * @param name the name of the quest_system.Quest to be completed
     */
    public void completeQuest(GameCharacter player, String name) {
        c.complete(player, this.getQuest(name));
    }

    public Object getQuests() {
        return new JSONObject(this.quests);
    }

}
