import java.util.*;

/**
 * Manages and tracks all quests in the game.
 */

public class QuestManager {

    CompleteQuest c = new CompleteQuest();

    private HashMap<String, Quest> quests = new HashMap<>();

    /**
     * Adds a Quest to the list of quests.
     * @param newQuest the Quest to be added
     */
    public void addQuest(Quest newQuest) {
        quests.put(newQuest.getName(), newQuest);
    }

    /**
     * Gets a Quest by name.
     * @param name the name of the Quest to be retrieved
     * @return the Quest with the specified name, or null if none exist
     */
    public Quest getQuest(String name) {
        return quests.get(name);
    }

    /**
     * Mark a Quest as completed.
     * @param player the Player character
     * @param name the name of the Quest to be completed
     */
    public void completeQuest(Character player, String name) {
        c.complete(player, this.getQuest(name));
    }

}
