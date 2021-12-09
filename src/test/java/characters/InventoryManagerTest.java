package characters;
import constants.Constants;
import items.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class InventoryManagerTest {

    private Inventory inventory;
    private Inventory testInventory;
    private InventoryManager inventoryManager;
    private WeaponItem knife;
    private WeaponItem claws;
    private HashMap<Item, Integer> testParam = new HashMap<>();
    private HashMap<Item, Integer> inventoryParam = new HashMap<>();

    @Before
    public void before() {
        this.knife = (WeaponItem) Constants.ITEM_LIST.get("sharp knife");
        this.claws =  (WeaponItem) Constants.ITEM_LIST.get("dirty claws");
        testParam.put(knife, 2);
        testParam.put(claws, 1);
        inventoryParam.put(knife, 2);
        inventory = new Inventory(inventoryParam);
        inventoryManager = new InventoryManager(inventory);
        testInventory = new Inventory(testParam);

    }

    @After
    public void after() {
        inventory = null;
        knife = null;
        claws = null;
        testInventory = null;
        inventoryParam = null;
    }

    /**
     * Test if addItem works correctly with no instance of the item, then test the actual 'adding' part.
     */
    @Test
    public void testAddItem(){
        inventoryManager.addItem("dirty claws", 1);
        Assert.assertEquals(testInventory.getInventory(), inventory.getInventory());
    }

    @Test
    public void testRemoveItem(){
        inventoryManager.removeItem("sharp knife", 1);
        testInventory.changeQuantity(knife, 1);
        testInventory.removeItem(claws);
        Assert.assertEquals(testInventory.getInventory(), inventory.getInventory());
    }

}
