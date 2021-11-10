package characters;

import java.util.ArrayList;
import java.util.HashMap;

import items.ArmourItem;
import items.WeaponItem;

import combat_system.StatusEffect;

import constants.Constants;

/**
 * An abstract class representing a character in the game.
 * Characters include both player and non-player characters.
 */
public abstract class GameCharacter {

    private int maxHealth;
    private int currentHealth;
    private HashMap<StatusEffect, Integer> statusEffects = new HashMap<>();
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
     * Gets the inventory of the characters.GameCharacter.
     * @return an ArrayList containing the inventory of the characters.GameCharacter
     */
    public ArrayList<String> getInventory() {
        return inventory;
    }

    /**
     * Gets the name of the characters.GameCharacter.
     * @return the name of the characters.GameCharacter
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the characters.GameCharacter owns an item.
     * @param item the item to be checked
     * @return whether the item is owned
     */
    public boolean checkItem(String item){
        return inventory.contains(item);
    }

    /**
     * Adds an item to the characters.GameCharacter's inventory.
     * @param item the item to be added
     */
    public void addItem(String item){
        inventory.add(item);
    }

    /**
     * Removes an item from the characters.GameCharacter's inventory.
     * @param item the item to be removed
     * @return whether the item was successfully removed
     */
    public boolean removeItem(String item){
        return inventory.remove(item);
    }

    /**
     * Gets the current health of the characters.GameCharacter.
     * @return the current health of the characters.GameCharacter
     */
    public int getCurrentHealth(){
        return this.currentHealth;
    }

    /**
     * Sets the health of the characters.GameCharacter.
     * @param currentHealth the new health of the characters.GameCharacter
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Gets the max health of the characters.GameCharacter.
     * @return the max health of the characters.GameCharacter
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Sets the max health of the characters.GameCharacter.
     * @param maxHealth the new max health of the characters.GameCharacter
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Gets status affects of the characters.GameCharacter.
     * @return the list of status effects affecting the characters.GameCharacter
     */
    public HashMap<StatusEffect, Integer> getStatusEffects(){
        return this.statusEffects;
    }

    /**
     * Sets a new status effect for the characters.GameCharacter.statusEffects
     * @param status the new status to add to characters.GameCharacter.statusEffects
     * @param duration the duration that the status will last for in rounds
     */
    public void setStatusEffect(StatusEffect status, Integer duration){
        if(duration > 0) {
            this.statusEffects.put(status, duration);
        }
        else {
            this.statusEffects.remove(status); //We could make this its own method
        }
    }

    /**
     * Gets the currently equipped weapon of the characters.GameCharacter.
     * @return the currently equipped weapon of the characters.GameCharacter
     */
    public WeaponItem getWeapon() {
        return weapon;
    }

    /**
     * Gets the currently equipped armour of the characters.GameCharacter.
     * @return the currently equipped armour of the characters.GameCharacter
     */
    public ArmourItem getArmor() {
        return armor;
    }

    // TODO: inventory manager implements equip/unequip armor and weapons

}
