package scene_system;

import characters.CharacterInventoryFacade;
import items.Item;
import scene_system.Scene;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Handles modifications and accessing of information from scene classes, and stores a hashmap
 * of the scenes in the game, that can be referenced by their names in string form.
 */
public class SceneManager {

    private HashMap<String, Scene> sceneList;

    public SceneManager(){}

    public SceneManager(HashMap<String, Scene> scenes){
        this.sceneList = scenes;
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
     * Gets a list of names of all the npcs in the given scene.
     * @param sceneName The name of the scene you are concerned with in String form.
     * @return an ArrayList containing the string names of all npcs in the area.
     */
    public ArrayList<String> getNpcNames(String sceneName){
        return this.sceneList.get(sceneName).getNpcNames();
    }

    /**
     * Gets a list of the facade classes of npcs in the given scene.
     * @param sceneName The name of the scene you are concerned with in String form.
     * @return an ArrayList containing the facades of the npcs in the scene.
     */
    public ArrayList<CharacterInventoryFacade> getNPC(String sceneName){
        return this.sceneList.get(sceneName).getNpc();
    }

}
