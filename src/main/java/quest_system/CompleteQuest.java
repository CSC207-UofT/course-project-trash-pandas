package quest_system;

import characters.CharacterInventoryFacade;
import characters.GameCharacter;
import quest_system.Quest;

public class CompleteQuest {

    public void complete(CharacterInventoryFacade player, Quest quest) {
        assert !quest.isComplete();

        for (String item : quest.getRewards()) {
            player.addItem(item, 1);
        }

        quest.toggleComplete();


    }

}
