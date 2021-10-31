import java.util.ArrayList;
import java.util.HashMap;

import items.ArmourItem;
import items.WeaponItem;

import constants.Constants;

/**
 * An abstract class representing a character in the game.
 * Characters include both player and non-player characters.
 */
public abstract class GameCharacter {

    private int maxHealth;
    private int currentHealth;
    private HashMap<String, Integer> statusEffects = new HashMap<String, Integer>();
    private ArrayList<String> inventory = new ArrayList<>();
    private String name;
    private WeaponItem weapon;
    private ArmourItem armor;

    public GameCharacter(int hp, String name){
        this.maxHealth = hp;
        this.currentHealth = hp;
        this.name = name;

        this.weapon = Constants.DEFAULT_WEAPON;
        this.armor = Constants.DEFAULT_ARMOR;
    }

    /**
     * Gets the inventory of the GameCharacter.
     * @return an ArrayList containing the inventory of the GameCharacter
     */
    public ArrayList<String> getInventory() {
        return inventory;
    }

    /**
     * Gets the name of the GameCharacter.
     * @return the name of the GameCharacter
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the GameCharacter owns an item.
     * @param item the item to be checked
     * @return whether the item is owned
     */
    public boolean checkItem(String item){
        return inventory.contains(item);
    }

    /**
     * Adds an item to the GameCharacter's inventory.
     * @param item the item to be added
     */
    public void addItem(String item){
        inventory.add(item);
    }

    /**
     * Removes an item from the GameCharacter's inventory.
     * @param item the item to be removed
     * @return whether the item was successfully removed
     */
    public boolean removeItem(String item){
        return inventory.remove(item);
    }

    /**
     * Gets the current health of the GameCharacter.
     * @return the current health of the GameCharacter
     */
    public int getCurrentHealth(){
        return this.currentHealth;
    }

    /**
     * Sets the health of the GameCharacter.
     * @param currentHealth the new health of the GameCharacter
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Gets the max health of the GameCharacter.
     * @return the max health of the GameCharacter
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Sets the max health of the GameCharacter.
     * @param maxHealth the new max health of the GameCharacter
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Gets status affects of the GameCharacter.
     * @return the list of status affects affecting the GameCharacter
     */
    public HashMap<String, Integer> getStatusEffects(){
        return this.statusEffects;
    }

    /**
     * Gets the currently equipped weapon of the GameCharacter.
     * @return the currently equipped weapon of the GameCharacter
     */
    public WeaponItem getWeapon() {
        return weapon;
    }

    /**
     * Gets the currently equipped armour of the GameCharacter.
     * @return the currently equipped armour of the GameCharacter
     */
    public ArmourItem getArmor() {
        return armor;
    }

    // TODO: inventory manager implements equip/unequip armor and weapons

}
