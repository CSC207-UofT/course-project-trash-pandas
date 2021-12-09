package characters;
import constants.Constants;
import items.Item;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import items.WeaponItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InventoryTest {

    private Inventory inventory;
    private WeaponItem knife;
    private WeaponItem claws;
    private HashMap<Item, Integer> testMap = new HashMap<>();
    private HashMap<Item, Integer> inventoryParam = new HashMap<>();

    @Before
    public void before() throws Exception{
        this.knife = (WeaponItem) Constants.ITEM_LIST.get("sharp knife") ;
        this.claws = (WeaponItem) Constants.ITEM_LIST.get("dirty claws");
        testMap.put(knife, 2);
        testMap.put(claws, 1);
        inventoryParam.put(knife, 2);
        inventoryParam.put(claws, 1);
        inventory = new Inventory(inventoryParam);
    }

    @After
    public void after() throws Exception {
        inventory = null;
        knife = null;
        claws = null;
        testMap = null;
        inventoryParam = null;
    }

    @Test
    public void testGetInventory(){
        Assert.assertEquals(testMap, inventory.getInventory());
    }

    @Test
    public void testGetQuantity(){
        Assert.assertEquals(2, inventory.getQuantity(knife));
    }

    @Test
    public void testContains(){
        Assert.assertTrue(inventory.contains(knife));
    }

    @Test
    public void testRemoveItem(){
        inventory.removeItem(claws);
        testMap.remove(claws);
        Assert.assertEquals(testMap, inventory.getInventory());
    }

    @Test
    public void testChangeQuantity(){
        inventory.changeQuantity(claws, 4);
        testMap.put(claws, 4);
        Assert.assertEquals(testMap, inventory.getInventory());
    }

    @Test
    public void testToString(){
        String testString = "Item Name: Sharp Knife\tQuantity: 2\n" +
                             "Item Name: Dirty Claws\tQuantity: 1\n";
        Assert.assertEquals(testString, inventory.toString());
    }

}
