import java.lang.reflect.Array;

public class NonPlayerCharacter extends Character {
    final int BEGIN_QUEST = 0;
    final int END_QUEST = 2;
    final int DURING_QUEST = 1;
    private String[] questDialogue = new String[3];
    private Quest quest;

    NonPlayerCharacter(int hp, String name, String begin, String middle, String end, Quest quest){
        super(hp, name);
        this.questDialogue[BEGIN_QUEST] = begin;
        this.questDialogue[DURING_QUEST] = middle;
        this.questDialogue[END_QUEST] = end;
        this.quest = quest;

    }

    NonPlayerCharacter(int hp, String name){
        super(hp, name);
    }

    public Quest getQuest() {
        return quest;
    }

    public String getQuestDialogue(int i) {
        return questDialogue[i];
    }
}
