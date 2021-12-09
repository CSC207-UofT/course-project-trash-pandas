package characters;
import constants.Constants;
import items.*;
/**
 * Manages a specified inventory in the game.
 */
public class InventoryManager {

    private final Inventory inventory;
    private final ItemList itemList = new ItemList();

    public InventoryManager(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * Add the specified amount of item to the inventory provided it is neither of the default items.
     * If the inventory already contains this item, increase the quantity of the item by the specified amount.
     * Otherwise, add the item to the inventory normally. Return adding the item is successful.
     * @param itemName the name of the item to be added
     * @param quantity the amount of the item to be added
     */
    public boolean addItem(String itemName, int quantity){
        Item item = itemList.getItem(itemName);
        if (!Constants.CANNOT_BE_ADDED.contains(item)){
            if (inventory.contains(item)){
                inventory.changeQuantity(item, inventory.getQuantity(item) + quantity);
            } else {
                inventory.changeQuantity(item, quantity);
            }
            return true;
        }
        return false;

    }

    /**
     * Remove the specified amount of an item from the inventory. IF the
     * @param itemName the item to be used
     */
    public void removeItem(String itemName, int quantity){
        Item item = itemList.getItem(itemName);
        int currentQuantity = inventory.getQuantity(item);
        if (currentQuantity <= quantity){
            inventory.removeItem(item);
        } else {
            inventory.changeQuantity(item, currentQuantity - quantity);
        }

    }

    /**
     * Return if the item is in the inventory
     * @param itemName the item we are checking for
     * @return if the item is in the inventory
     */
    public boolean checkItem(String itemName){
        Item item = itemList.getItem(itemName);
        return inventory.contains(item);
    }

    public String getInventory(){
        return inventory.toString();
    }
}
