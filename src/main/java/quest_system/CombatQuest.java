package quest_system;

import characters.ItemCheckable;
import characters.NonPlayerCharacter;
import items.QuestItem;

import java.util.HashSet;
import java.util.Set;

public class CombatQuest extends Quest{

    private Set<NonPlayerCharacter> npcs = new HashSet<>();

    /**
     * creates an instance of a CombatQuest
     * @param npcs the NonPlayerCharacters that must be killed to complete the quest
     */
    public CombatQuest(Set<NonPlayerCharacter> npcs){
        this.npcs.addAll(npcs);
    }

    /**
     * Checks if there are any requirements left, if there aren't, completes the quest
     */
    public void checkDone() {
        if(this.npcs.isEmpty() && this.isAccepted()){
            this.toggleComplete();
        }
    }

    /**
     * removes args from the set npcs
     * @param args the NonPlayerCharacters to be removed from npcs
     */
    @Override
    public void update(Object args) {
        if (args != null && this.npcs.contains(((NonPlayerCharacter) args))){
            this.npcs.remove((NonPlayerCharacter)args);
        }
    }
}
