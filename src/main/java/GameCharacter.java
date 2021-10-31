import java.util.ArrayList;
import java.util.HashMap;

import items.ArmourItem;
import items.WeaponItem;

import constants.Constants;

/**
 * An abstract class representing a Character.
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

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public boolean checkItem(String item){
        return inventory.contains(item);
    }

    public void addItem(String item){
        inventory.add(item);
    }

    public boolean removeItem(String item){
        return inventory.remove(item);
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public HashMap<String, Integer> getStatusEffects(){
        return this.statusEffects;
    }

    public WeaponItem getWeapon() {
        return weapon;
    }

    public ArmourItem getArmor() {
        return armor;
    }

    // TODO: inventory manager implements equip/unequip armor and weapons

}
