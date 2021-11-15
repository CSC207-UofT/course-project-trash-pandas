package characters;
import items.Item;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * A class representing an inventory of items for a character. The class contains a Map attribute that represents the
 * inventory, where the keys are Item objects and the values are the quantity of the item within the inventory.
 */
public class Inventory {

    private final Map<Item, Integer> inventory;

    public Inventory(){
        this.inventory = new HashMap<>();
    }

    public Inventory(HashMap<Item, Integer> inv){
        this.inventory = inv;
    }

    /**
     * Get the Inventory object.
     * @return the Inventory instance variable
     */
    public Map<Item, Integer> getInventory() {
        return this.inventory;
    }


    /**
     * Return the quantity of a specified Item object in the Inventory.
     * @param itemName the name of the item
     * @return the quantity of numbers in the inventory
     */
    public int getQuantity(Item itemName){
        return this.inventory.get(itemName);
    }
    /**
     * Return if the inventory contains the specified item.
     * @param itemName the item that we are looking for in inventory
     * @return true if the inventory has a key matching itemName
     */
    public boolean contains(Item itemName){
        return this.inventory.containsKey(itemName);
    }

    /**
     * Remove all quantities of an object from the Inventory
     * @param itemName the item to be removed
     */
    public void removeItem(Item itemName){
        this.inventory.remove(itemName);
    }

    /**
     * Change the quantity of the specified Item in the inventory
     * @param itemName the name of the Item whose quantity is being modified
     * @param quantity the new quantity of the Item
     */
    public void changeQuantity(Item itemName, int quantity){
        this.inventory.put(itemName, quantity);
    }

    /**
     * Return a String representation of the Inventory.
     * @return A string containing each Item in the inventory and its quantity.
     */
    // TODO: fix this stringbuilder style error which i am too lazy to do right now
    @Override
    public String toString(){
        String toReturn = "";
        for (Item i: this.inventory.keySet()){
            toReturn += (i + ". " + i.getName() + "\t" + this.inventory.get(i) + "\n");
        }
        return toReturn;
    }

}
