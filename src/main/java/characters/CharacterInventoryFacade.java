package characters;

import constants.Constants;
import constants.Observer;
import items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A facade class that provides a unified interface for Characters and Inventory interactions.
 * It is assumed that the Character and Inventory instances passed into CharacterInventoryFacade are linked:
 * the Inventory instance being passed in is the inventory of the Character instance.
 */
public class CharacterInventoryFacade implements ItemCheckable {

    private final InventoryManager inventory;
    private CharacterManager character;
    private final ItemList itemList = new ItemList();
    private List<Observer> observers;

    public CharacterInventoryFacade(Inventory inventory, GameCharacter character, List<Observer> observers){
        this.inventory = new InventoryManager(inventory);
        this.character = new CharacterManager(character);
        this.observers = observers;
    }

    /**
     * Consumes the specified item from the inventory.
     * Applies its effects to the consuming character.
     *
     * @param itemName the item being consumed
     */
    public void consumeItem(String itemName, int quantity){
        Item item = itemList.getItem(itemName);
        if (item instanceof HealingItem){
            character.consumeHeal(itemName, quantity);
            inventory.removeItem(itemName, quantity);

        }
        else if (item instanceof StatusItem) {
            character.consumeStatus(itemName);
        }
    }

    /**
     * Remove the specified amount of healing items from the inventory and apply the healing that many times
     * @param itemName the name of the item
     * @param quantity the amount of potions to consume
     */
    public void consumeHeal(String itemName, int quantity){
        Item item = itemList.getItem(itemName);
        character.consumeHeal(itemName, quantity);
        inventory.removeItem(itemName,quantity);
    }

     * Returns the character for this facade.
     *
     * @return the character for this facade
     */
    public CharacterManager getCharacter() {
        return character;
    }

    /**
     * Returns the text representation of the inventory for this facade's character.
     *
     * @return the inventory for this facade's character
     */
    public String getInventory() {
        return this.inventory.getInventory();
    }

    /**
     * Adds an WeaponItem or ArmorItem back to the inventory and modify character accordingly.
     *
     * @param itemName the item being unequipped
     */
    public void unequipItem(String itemName){
        Item item = itemList.getItem(itemName);

        if (item != Constants.DEFAULT_ARMOR && item != Constants.DEFAULT_WEAPON) {
            inventory.addItem(itemName, 1);
            if (item instanceof ArmorItem) {
                character.unequipArmor();
            } else if (item instanceof WeaponItem) {
                character.unequipWeapon();
            }
        }
    }

    /**
     * Equips the specified item from the inventory.
     * Also removes the item from the inventory.
     *
     * @param itemName the name of the item
     */
    public void equipItem(String itemName){
        Item item = itemList.getItem(itemName);
        inventory.removeItem(itemName, 1);
        if (item instanceof ArmorItem){
            character.equipArmor(itemName);
        } else if (item instanceof WeaponItem){
            character.equipWeapon(itemName);
        }
    }

    /**
     * Adds the item to the inventory in the given quantity.
     *
     * @param itemName the name of the item
     * @param quantity the quantity of the item
     */
    public void addItem(String itemName, int quantity){
        inventory.addItem(itemName, quantity);
        for (Observer observer: this.observers){
            observer.update(this.itemList.getItem(itemName));
        }
    }

    /**
     * Checks if the item is in the inventory.
     * @param itemName the name of the item
     * @return whether the item is in the inventory
     */
    @Override
    public boolean checkItem(String itemName){
        return inventory.checkItem(itemName);
    }

    /**
     * Returns the name of the character.
     * @return the name of the character
     */
    public String getName(){
        return this.character.getName();
    }

}
