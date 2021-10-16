package java;

public class DisplayDialogue {

    public String dialogue(NonPlayerCharacter chara, PlayerCharacter player){
        Quest quest = chara.getQuest();
        AcceptQuest acceptQuest = new AcceptQuest();
        CompleteQuest completeQuest = new CompleteQuest();
        if(quest == null){
            return "ew stinky";
        }
        switch (quest.getCompletion()) {
            case 0 -> {
                acceptQuest.accept(quest);
                return chara.getQuestDialogue(chara.BEGIN_QUEST);
            }
            case 1 -> {
                if (quest.checkDone(player)) {
                    completeQuest.complete(player, quest);
                    return chara.getQuestDialogue(chara.END_QUEST);
                }
                return chara.getQuestDialogue(chara.DURING_QUEST);
            }
        }
        return "how";

    }
}
