package items;

/**
 * A class representing equipable armour.
 */
public class ArmorItem extends Item{

    private final int defense;
    private final int bonusHealth;

    public ArmorItem(String name, String description, int defense, int health){
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

    @Override
    public String toString(){

        return super.toString() +
                " Defense: " +
                defense +
                " Bonus HP: " +
                bonusHealth;
    }
}
