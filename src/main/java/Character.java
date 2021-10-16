import java.util.ArrayList;

public abstract class Character {


    private int health;
    private ArrayList<String> inventory = new ArrayList<>();
    private String name;

    Character(int hp, String name){
        this.health = hp;
        this.name = name;
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

}
