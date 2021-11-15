package scene_system;

import characters.PlayerCharacter;
import quest_system.Quest;
import quest_system.QuestManager;
import characters.*;


public class DisplayDialogue {

    public String dialogue(NonPlayerCharacter chara, CharacterInventoryFacade player){
        Quest quest = chara.getQuest();
        QuestManager manager = new QuestManager();
        if(quest != null) {
            switch (quest.getCompletion()) {
                case 0:
                    manager.acceptQuest(quest);
                    return chara.getQuestDialogue(chara.BEGIN_QUEST);

                case 1:
                    if (quest.checkDone(player)) {
                        manager.completeQuest(player, quest);
                        return chara.getQuestDialogue(chara.END_QUEST);
                    }
                    return chara.getQuestDialogue(chara.DURING_QUEST);
            }
        }

        return "ew stinky";

    }
}
