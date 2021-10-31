package items;

/**
 * A class representing equipable armour.
 */
public class ArmourItem extends Item{

    private int defense;
    private int bonusHealth;

    public ArmourItem(String name, String description, int defense, int health){
        super(name, description);
        this.defense = defense;
        this.bonusHealth = health;
    }

    public int getDefense() {
        return defense;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }
}
