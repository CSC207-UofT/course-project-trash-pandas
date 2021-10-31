import java.util.ArrayList;

/**
 * Represents a character in the game.
 * Characters include both player and non-player characters.
 */
public abstract class Character {

    private int health;
    private ArrayList<String> inventory = new ArrayList<>();
    private String name;

    public Character(int hp, String name){
        this.health = hp;
        this.name = name;
    }

    /**
     * Gets the inventory of the Character.
     * @return an ArrayList containing the inventory of the Character
     */
    public ArrayList<String> getInventory() {
        return inventory;
    }

    /**
     * Gets the name of the Character.
     * @return the name of the Character
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the Character owns an item.
     * @param item the item to be checked
     * @return whether the item is owned
     */
    public boolean checkItem(String item){
        return inventory.contains(item);
    }

    /**
     * Adds an item to the Character's inventory.
     * @param item the item to be added
     */
    public void addItem(String item){
        inventory.add(item);
    }

    /**
     * Removes an item from the Character's inventory.
     * @param item the item to be removed
     * @return whether the item was successfully removed
     */
    public boolean removeItem(String item){
        return inventory.remove(item);
    }

}
