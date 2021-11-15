package scene_system;

import characters.NonPlayerCharacter;
import items.ArmourItem;
import items.Item;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

public class SceneTest extends TestCase {
    private Scene scene;

    @Before
    public void before() throws Exception {
        NonPlayerCharacter npc = new NonPlayerCharacter(5, "tim");
        ArrayList<NonPlayerCharacter> npcs = new ArrayList<>();
        npcs.add(npc);
        ArrayList<Item> items = new ArrayList<>();
        items.add(new ArmourItem("helmet", "head", 1, 1));
        scene = new Scene("place", npcs, "test area", items);
    }

    @After
    public void after() throws Exception {
        scene = null;
    }

    public void testGetDescription() {
        assertEquals("test area", scene.getDescription());
    }

    public void testTestGetName() {
        assertEquals("place",scene.getName());
    }

    public void testGetConnectedAreas() {
        ArrayList<Scene> empty = new ArrayList<>();
        assertEquals(empty,scene.getConnectedAreas());
    }

    public void testGetItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new ArmourItem("helmet", "head", 1, 1));
        assertEquals(items, scene.getItems());
    }

    public void testGetNpc() {
        ArrayList<NonPlayerCharacter> npcs = new ArrayList<>();
        npcs.add( new NonPlayerCharacter(5, "tim"));
        assertEquals(npcs, scene.getNpc());
    }

    public void testRemoveItem() {
        Item item = new ArmourItem("helmet", "head", 1, 1);
        scene.removeItem(item);
        ArrayList<Item> empty = new ArrayList<>();
        assertEquals(empty, scene.getItems());
    }

    public void testAddScene() {
        Scene place = new Scene("top", new ArrayList<NonPlayerCharacter>(), "top",new ArrayList<Item>());
        scene.addScene(place);
        ArrayList<Scene> scenes = new ArrayList<>();
        scenes.add(place);
        assertEquals(scenes, scene.getConnectedAreas());
    }
}