package quest_system;

import characters.ItemCheckable;
import characters.NonPlayerCharacter;
import items.QuestItem;

import java.util.HashSet;
import java.util.Set;

public class CombatQuest extends Quest{

    private Set<NonPlayerCharacter> npcs = new HashSet<>();

    public CombatQuest(Set<NonPlayerCharacter> npcs){
        this.npcs.addAll(npcs);
    }

    public void checkDone() {
        if(this.npcs.isEmpty() && this.isAccepted()){
            this.toggleComplete();
        }
    }

    @Override
    public void update(Object args) {
        if (args != null && this.npcs.contains(((NonPlayerCharacter) args))){
            this.npcs.remove((NonPlayerCharacter)args);
        }
    }
}
