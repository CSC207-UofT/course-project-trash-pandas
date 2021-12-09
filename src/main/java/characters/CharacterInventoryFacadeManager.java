package characters;

import scene_system.DisplayDialogue;

import java.util.HashMap;

public class CharacterInventoryFacadeManager {

    HashMap<String, CharacterInventoryFacade> charInventFacades;

    /**
     * Instantiates the class. This is used to keep track of all npcs in the game and access them through
     * their name strings.
     *
     * @param ciFacades a hashmap containing all CharacterInventoryFacades, with the name of the character as the key.
     */
    public CharacterInventoryFacadeManager(HashMap<String, CharacterInventoryFacade> ciFacades) {
        this.charInventFacades = ciFacades;
    }

    /**
     * Returns the dialogue for an npc
     *
     * @param npcName the name of an npc. Must be an nonplayercharacter
     * @return a string of the character's dialogue
     */
    public String getDialogue(String npcName) {
        DisplayDialogue disp = new DisplayDialogue();
        return disp.dialogue((NonPlayerCharacter) charInventFacades.get(npcName).getCharacter().getCharacter());
    }
}
