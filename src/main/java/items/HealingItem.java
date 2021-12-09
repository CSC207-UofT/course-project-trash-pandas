package items;
import characters.GameCharacter;

/**
 * A class representing a healing consumable item.
 */
public class HealingItem extends Item {

    private final int healingAmount;

    public HealingItem(String name, String description, int healingAmount){
        super(name, description);
        this.healingAmount = healingAmount;
    }

    /**
     * A method to return the amount that the consumable will heal.
     * @return healingAmount the amount of healing the item provides
     */
    public int getHealingAmount() {
        return healingAmount;
    }

}
