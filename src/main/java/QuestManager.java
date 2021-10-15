package java;

import java.util.*;

public class QuestManager {

    CompleteQuest c = new CompleteQuest();

    private HashMap<String, Quest> quests = new HashMap<>();

    public void addQuest(Quest newQuest) {
        quests.put(newQuest.getName(), newQuest);
    }

    public Quest getQuest(String name) {
        return quests.get(name);
    }

    public void completeQuest(Character player, String name) {
        c.complete(player, this.getQuest(name));
    }

}
