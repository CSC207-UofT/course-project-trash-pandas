package characters;

import characters.GameCharacter;
import quest_system.Quest;

public class NonPlayerCharacter extends GameCharacter {
    public final int BEGIN_QUEST = 0;
    public final int END_QUEST = 2;
    public final int DURING_QUEST = 1;
    private String[] questDialogue = new String[3];
    private Quest quest;
    private String combatDialogue;

    public NonPlayerCharacter(int hp, String name, String begin, String middle, String end, Quest quest, String combatDialogue){
        super(hp, name);
        this.questDialogue[BEGIN_QUEST] = begin;
        this.questDialogue[DURING_QUEST] = middle;
        this.questDialogue[END_QUEST] = end;
        this.quest = quest;
        this.combatDialogue = combatDialogue;

    }

    public NonPlayerCharacter(int hp, String name){
        super(hp, name);
    }

    public Quest getQuest() {
        return quest;
    }

    public String getQuestDialogue(int i) {
        return questDialogue[i];
    }

    public String getCombatDialogue() {return combatDialogue;}
}
