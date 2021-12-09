package scene_system;

import characters.CharacterInventoryFacade;
import combat_system.Combat;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles modifications and accessing of information from scene classes, and stores a hashmap
 * of the scenes in the game, that can be referenced by their names in string form.
 */
public class SceneManager {

    private final HashMap<String, Scene> sceneList;

    /**
     * Instantiates the scene manager
     * @param scenes a hashmap of scenes, where the scene name is the key for each scene
     */
    public SceneManager(HashMap<String, Scene> scenes){
        this.sceneList = scenes;
    }

    /**
     * Gets all scenes in the game
     * @return an ArrayList of names of scenes in the game.
     */
    public ArrayList<String> getSceneList() {
        ArrayList<String> scenes = new ArrayList<>(sceneList.keySet());
        return scenes;
    }

    /**
     * Return the description of the scene
     * @param scene the scene_system.Scene to be returned
     * @return a string description of the scene
     */
    public String displayScene(Scene scene) {
        return scene.getDescription();
    }

    /**
     * Returns the description of the scene
     * @param sceneName the string containing the name of the scene.
     * @return the description of the scene to be displayed.
     */
    public String displayScene(String sceneName) {
        return this.sceneList.get(sceneName).getDescription();
    }

    /**
     * Returns an array list containing the connected areas to the given scene.
     * @param sceneName The name of the scene you are looking for the connecting areas of in String form.
     * @return the ArrayList containing the string names of all connected areas to the given scene.
     */
    public ArrayList<String> getTravelOptions(String sceneName){
        return this.sceneList.get(sceneName).getConnectedAreaNames();
    }

    /**
     * Gets a list of the names of npcs in the given scene.
     * @param sceneName The name of the scene you are concerned with in String form.
     * @return an ArrayList containing the names of the npcs in the scene.
     */
    public ArrayList<String> getNPC(String sceneName){
        Scene scene = this.sceneList.get(sceneName);

        return scene.getNpc();
    }

    /**
     * Gets a list of names of items in the given scene.
     * @param sceneName the name of the scene you want to retrieve from
     * @return an  ArrayList of the names of items in the scene
     */
    public ArrayList<String> getItems(String sceneName) {
        ArrayList<String> itemNames = new ArrayList<>();
        for(Item i : this.sceneList.get(sceneName).getItems()) {
            itemNames.add(i.getName());
        }
        return itemNames;
    }

    /**
     * Removes an item from the scene that matches the name of the item given.
     * @param sceneName the name of the scene being removed from.
     * @param item the name of the item that should be removed.
     */
    public void removeItem(String sceneName, String item) {
        for(Item i : this.sceneList.get(sceneName).getItems()) {
            if(i.getName().equals(item)){
                this.sceneList.get(sceneName).removeItem(i);
            }
        }
    }

    /**
     * Gets the combat instance from the given scene.
     * @param sceneName the name of the scene the combat takes place in
     * @param participants the characters that take part in combat
     * @return the instance of combat in the given scene.
     */
    public Combat getCombat(String sceneName, ArrayList<CharacterInventoryFacade> participants){
        return this.sceneList.get(sceneName).getCombat(participants);
    }

    public void removeDead(String sceneName){
        sceneList.get(sceneName).removeDead();
    }
}
