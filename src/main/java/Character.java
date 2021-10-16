package java;

import java.util.ArrayList;

public class Character {

    private int health;
    private ArrayList<String> inventory;
    private String name;

    public Character(int hp, String name){
        this.health = hp;
        this.name = name;
    }

    public ArrayList<String> getInventory() {
        return inventory;
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

}
