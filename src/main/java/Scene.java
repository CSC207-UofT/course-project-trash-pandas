import java.util.ArrayList;

/**
 * Represents a scene in the game.
 */
public class Scene {

    private String name;
    private ArrayList<NonPlayerCharacter> npc;
    private String area_description;
    private ArrayList<Scene> connectedAreas;
    private ArrayList<String> items;

    /**
     * Constructor for the Scene class.
     * @param name the name of the Scene
     * @param npc the list of NPCs in the Scene
     * @param area the text description of the location in the Scene
     * @param items the items located in the Scene
     */
    public Scene(String name, ArrayList<NonPlayerCharacter> npc, String area,
          ArrayList<String> items) {
        this.name = name;
        this.npc = npc;
        this.area_description = area;
        this.connectedAreas = new ArrayList<>();
        this.items = items;
    }

    /**
     * Gets the description of the Scene.
     * @return the text description of the Scene
     */
    public String getDescription() {
        return this.area_description;
    }

    /**
     * Gets the name of the Scene.
     * @return the name of the Scene
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
     * Gets the list of items in the Scene.
     * @return the list of items in the Scene
     */
    public ArrayList<String> getItems() {
        return items;
    }

    /**
     * Gets the list of NPCs in the Scene.
     * @return the list of NPCs in the Scene
     */
    public ArrayList<NonPlayerCharacter> getNpc() {
        return npc;
    }

    /**
     * Removes an item from the Scene.
     * @param item the item to be removed
     */
    public void removeItem(String item){
        this.items.remove(item);
    }

    /**
     * Adds a connection to another scene.
     * Scene connections are unidirectional by default.
     * @param scene the Scene to be connected
     */
    public void addScene(Scene scene){
        this.connectedAreas.add(scene);
    }
}
