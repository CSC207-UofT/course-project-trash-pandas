package scene_system;

import characters.PlayerCharacter;
import quest_system.QuestManager;
import quest_system.Quest;
import characters.*;


public class DisplayDialogue {

    public String dialogue(NonPlayerCharacter chara, PlayerCharacter player){
        Quest quest = chara.getQuest();
        if(quest == null){
            return "ew stinky";
        }
        switch (quest.getCompletion()) {
            case 0:
                player.accept(quest);
                return chara.getQuestDialogue(chara.BEGIN_QUEST);

            case 1:
                if (quest.checkDone(player)) {
                    player.complete(player, quest);
                    return chara.getQuestDialogue(chara.END_QUEST);
                }
                return chara.getQuestDialogue(chara.DURING_QUEST);
        }
        return "how";

    }
}
