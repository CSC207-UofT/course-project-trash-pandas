package java;

import java.util.ArrayList;

public class Character {


    protected int health;
    protected ArrayList<String> inventory;

    Character(int hp){
        this.health = hp;
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
