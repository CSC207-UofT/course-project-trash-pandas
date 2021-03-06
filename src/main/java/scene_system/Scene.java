package scene_system;

import characters.CharacterInventoryFacade;
import constants.Observer;
import items.Item;

import combat_system.Combat;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a scene in the game.
 */
public class Scene {

    private final String name;
    private ArrayList<String> npc;
    private final String area_description;
    private final ArrayList<Scene> connectedAreas;
    private ArrayList<Item> items;
    private Combat combat;
    private List<Observer> observers;

    /**
     * Constructor for the scene_system.Scene class.
     * @param name the name of the scene_system.Scene
     * @param npc the list of names of NPCs in the scene_system.Scene
     * @param area the text description of the location in the scene_system.Scene
     * @param items the items located in the scene_system.Scene
     */
    public Scene(String name, ArrayList<String> npc, String area,
          ArrayList<Item> items, List<Observer> observers) {
        this.name = name;
        this.npc = npc;
        this.area_description = area;
        this.connectedAreas = new ArrayList<>();
        this.items = items;
        this.observers = observers;
    }

    /**
     * Gets the description of the scene_system.Scene.
     * @return the text description of the scene_system.Scene
     */
    public String getDescription() {
        return this.area_description;
    }

    /**
     * Gets the name of the scene_system.Scene.
     * @return the name of the scene_system.Scene
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the list of connected areas.
     * @return the list of connected areas
     */
    public ArrayList<Scene> getConnectedAreas() {
        return connectedAreas;
    }

    /**
     * Gets the list of items in the scene_system.Scene.
     * @return the list of items in the scene_system.Scene
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Gets the list of NPCs in the scene_system.Scene.
     * @return the list of NPCs in the scene_system.Scene
     */
    public ArrayList<String> getNpc() {return npc;}

    /**
     * Removes an item from the scene_system.Scene.
     * @param item the item to be removed
     */
    public void removeItem(Item item){
        this.items.remove(item);
    }

    /**
     * Adds a connection to another scene.
     * scene_system.Scene connections are unidirectional by default.
     * @param scene the scene_system.Scene to be connected
     */
    public void addScene(Scene scene){
        this.connectedAreas.add(scene);
    }

    /**
     * Removes dead npcs
     * This should update world state as well
     */
    //TODO Figure out if we need this at all
    public void removeDead() {
        while(!npc.isEmpty()){
            this.npc = new ArrayList<>();
        }

    }

    /**
     * This method is called when combat begins
     * After combat is resolved, it checks the npcs that are alive since many probably died.
     * This leaves room for expansion if there are non-lethal options in combat (check_alive can be expanded)
     * @param participants a list containing the player character and npcs partaking in combat.
     */
    public Combat getCombat(ArrayList<CharacterInventoryFacade> participants) {
        if(combat == null) {
            this.combat = new Combat(participants, this.observers);
        }
        return this.combat;
    }

    /**
     * Gets a list of the names of all connected areas.
     * @return the array list containing the string names of all connected scenes to this one.
     */
    public ArrayList<String> getConnectedAreaNames() {
        ArrayList<String> areaNames = new ArrayList<>();
        for(Scene sc : connectedAreas) {
            areaNames.add(sc.getName());
        }
        return areaNames;
    }
}

