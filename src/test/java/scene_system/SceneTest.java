package scene_system;

import characters.CharacterInventoryFacade;
import characters.Inventory;
import characters.NonPlayerCharacter;
import constants.Constants;
import items.ArmorItem;
import items.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SceneTest {
    private Scene scene;
    private CharacterInventoryFacade npc;

    @Before
    public void before() throws Exception {
        NonPlayerCharacter npc = new NonPlayerCharacter(5, "tim");
        Inventory inventory = new Inventory();
        CharacterInventoryFacade tim = new CharacterInventoryFacade(inventory, npc, List.of());
        this.npc = tim;
        ArrayList<CharacterInventoryFacade> npcs = new ArrayList<>();
        npcs.add(tim);
        ArrayList<Item> items = new ArrayList<>();
        items.add(Constants.ITEM_LIST.get("dirty claw"));
        scene = new Scene("place", npcs, "test area", items, List.of());
    }

    @After
    public void after() throws Exception {
        scene = null;
    }

    @Test
    public void testGetDescription() {
        Assert.assertEquals("test area", scene.getDescription());
    }

    @Test
    public void testTestGetName() {
        Assert.assertEquals("place", scene.getName());
    }

    @Test
    public void testGetConnectedAreas() {
        ArrayList<Scene> empty = new ArrayList<>();
        Assert.assertEquals(empty, scene.getConnectedAreas());
    }

    @Test
    public void testGetItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(Constants.ITEM_LIST.get("dirty claw"));
        Assert.assertEquals(items, scene.getItems());
    }

    @Test
    public void testGetNpc() {
        ArrayList<CharacterInventoryFacade> npcs = new ArrayList<>();
        npcs.add(this.npc);
        Assert.assertEquals(npcs, scene.getNpc());
    }

    @Test
    public void testRemoveItem() {
        scene.removeItem(Constants.ITEM_LIST.get("dirty claw"));
        ArrayList<Item> empty = new ArrayList<>();
        Assert.assertEquals(empty, scene.getItems());
    }

    @Test
    public void testAddScene() {
        Scene place = new Scene("top", new ArrayList<CharacterInventoryFacade>(), "top",
                new ArrayList<Item>(), List.of());
        scene.addScene(place);
        ArrayList<Scene> scenes = new ArrayList<>();
        scenes.add(place);
        Assert.assertEquals(scenes, scene.getConnectedAreas());
    }
}