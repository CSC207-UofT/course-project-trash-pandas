package characters;

import scene_system.DisplayDialogue;

import java.util.ArrayList;
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
     * Returns the dialogue from an npc.
     *
     * @param npcName the name of the npc to retrieve dialogue from. Must be a NonPlayerCharacter
     * @return a string of the npc's dialogue
     */
    public String getDialogue(String npcName) {
        DisplayDialogue disp = new DisplayDialogue();
        return disp.dialogue((NonPlayerCharacter) charInventFacades.get(npcName).getCharacter().getCharacter());
    }

    /**
     * Returns the combat dialogue from an npc.
     *
     * @param npcName the name of the npc to retrieve dialogue from. Must be a NonPlayerCharacter
     * @return a string of the npc's combat dialogue.
     */
    public String getCombatDialogue(String npcName) {
        return ((NonPlayerCharacter) charInventFacades.get(npcName).getCharacter().getCharacter()).getCombatDialogue();
    }

    /**
     * Returns a list of npc facades to be used in combat.
     * @param names the names of the npcs participating in combat.
     * @return the CharacterInventoryFacades for combat to use.
     */
    public ArrayList<CharacterInventoryFacade> getCombatParticipants(ArrayList<String> names){
        ArrayList<CharacterInventoryFacade> combatants = new ArrayList<>();
        for(String name : names){
            combatants.add(charInventFacades.get(name));
        }
        return combatants;
    }
}
