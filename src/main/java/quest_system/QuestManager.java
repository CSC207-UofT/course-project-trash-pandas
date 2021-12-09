package quest_system;

import characters.CharacterInventoryFacade;
//import org.json.simple.JSONObject;
import characters.NonPlayerCharacter;
import items.QuestItem;
import constants.Observer;
import items.ItemList;


import java.util.*;

/**
 * Manages and tracks all quests in the game.
 */

public class QuestManager implements Observer {


    private HashMap<String, Quest> quests = new HashMap<>();
    private HashMap<String, Quest> acceptedQuests = new HashMap<>();
    private ItemList items = new ItemList();

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

    public void addReward(String item, String quest){
        quests.get(quest).addReward(item);
    }


    /**
     * Mark a quest_system.Quest as completed and issue rewards.
     * @param player the player Character completing the quest_system.Quest
     * @param quest the quest_system.Quest to be completed
     */
    public void completeQuest(CharacterInventoryFacade player, Quest quest) {
        assert !quest.isComplete();

        for (String item : quest.getRewards()) {
            player.addItem(item, 1);
        }

        quest.toggleComplete();


    }

    /**
     * Mark a quest_system.Quest as accepted.
     * @param quest the quest_system.Quest to be accepted
     */
    public void acceptQuest(Quest quest) {
        assert !quest.isAccepted();

        quest.toggleAccepted();
        this.acceptedQuests.put(quest.getName(),quest);
    }

    /**
     * updates the quests of a certain type depending on the type of arg
     * @param arg either an NonPlayerCharacter or QuestItem to be removed from quest requirements
     */
    @Override
    public void update(Object arg) {
        if(arg instanceof QuestItem){
            for(Quest quest: quests.values()){
                if (quest instanceof FetchQuest){
                    quest.update(arg);
                }
            }
        } else if (arg instanceof NonPlayerCharacter){
            for(Quest quest: quests.values()){
                if (quest instanceof CombatQuest){
                    quest.update(arg);
                }
            }
        }
    }

//    public Object getQuests() {
//        return new JSONObject(this.quests);
//    }

}
