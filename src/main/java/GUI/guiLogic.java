package GUI;

import characters.CharacterInventoryFacade;
import items.Item;
import scene_system.Scene;

import java.util.ArrayList;

public class guiLogic {

    /**
     * Returns a list of all the valid options to travel to
     * @param travelOptions an array list of names of scenes you can travel to
     * @return text is an array list that has maintext at element 1 and entryField text at element 0
     */
    public ArrayList<String> displayTravelOptions (ArrayList<String> travelOptions) {
        ArrayList<String> text = new ArrayList<>();
        StringBuilder travelText = new StringBuilder();
        boolean first = true;
        text.add("Write Destination Here");
        travelText.append("Where would you like to travel? \n");
        for(String sc: travelOptions) {
            if (!first) {
                travelText.append(", ").append(sc);
            }
            else {
                travelText.append(sc);
                first = false;
            }
        }
        text.add(travelText.toString());
        return text;
    }
    /**
     * Displays all the options of npcs to talk to
     * @param characters a list of all the names of npcs in the current scene
     * @return an array list that has maintext at element 1 and entryField text at element 0
     */
    public ArrayList<String> displayNpcs (ArrayList<String> characters) {
        ArrayList<String> text = new ArrayList<>();
        StringBuilder npcText = new StringBuilder();
        if(characters.isEmpty()) {
            npcText.append("There is no one here to talk to");
            text.add("There is no one here");
        }
        else {
            boolean first = true;
            text.add("Write NPC Here");
            npcText.append("Who would you like to talk to? \n");
            for(String npc: characters) {
                if (!first) {
                    npcText.append("\n").append(npc);
                }
                else {
                    npcText.append(npc);
                    first = false;
                }
            }
        }
        text.add(npcText.toString());
        return text;
    }

    /**
     * Returns an ArrayList that contains maintext at element 1 and entryField text at element 0
     * @param items an array list of all the names of items a player has
     * @return text is an array list of objects
     */
    public ArrayList<String> displayItems(ArrayList<String> items) {
        ArrayList<String> text = new ArrayList<>();
        StringBuilder itemText = new StringBuilder();
        if(items.isEmpty()) {
            itemText.append("There are no items around that you can see");
            text.add("There are no items");
        }
        else {
            boolean first = true;
            text.add("Write Item Here");
            itemText.append("Which item would you like to pick up? \n");
            for(String item: items) {
                if (!first) {
                    itemText.append(", ").append(item);
                }
                else {
                    itemText.append(item);
                    first = false;
                }
            }
        }
        text.add(itemText.toString());
        return text;
    }
}
