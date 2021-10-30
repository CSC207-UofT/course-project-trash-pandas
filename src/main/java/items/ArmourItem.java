package items;

/**
 * A class representing equipable armour.
 */
public class ArmourItem extends Item{

    private int defense;

    public ArmourItem(String name, String description, int defense){
        super(name, description);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

}
