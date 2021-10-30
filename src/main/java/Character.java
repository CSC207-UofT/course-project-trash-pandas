import items.ArmourItem;
import items.WeaponItem;

import java.util.ArrayList;

public abstract class Character {

    private int maxHealth;
    private int currentHealth;
    private String status;
    private ArrayList<String> inventory = new ArrayList<>();
    private String name;
    private WeaponItem weapon;
    private ArmourItem armor;


    public Character(int hp, String name){
        this.maxHealth = hp;
        this.currentHealth = hp;
        this.name = name;
        this.status = "normal";
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // TODO: add equip and unequip methods for Character

}
