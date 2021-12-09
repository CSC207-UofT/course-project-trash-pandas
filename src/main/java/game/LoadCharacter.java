package game;

import characters.CharacterInventoryFacade;
import characters.Inventory;
import characters.NonPlayerCharacter;

import java.util.List;

public class LoadCharacter {

    NonPlayerCharacter timC = new NonPlayerCharacter(1, "Tim", beginDialogue,
            duringDialogue, endingDialogue, coinQuest, combatDialogue);
    NonPlayerCharacter evanC = new NonPlayerCharacter(1, "Evan", beginDialogue,
            duringDialogue, endingDialogue, coinQuest, combatDialogue);
    Inventory timInventory = new Inventory();
    CharacterInventoryFacade tim = new CharacterInventoryFacade(timInventory, timC, List.of());
}
