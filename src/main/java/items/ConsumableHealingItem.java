package items;
import characters.GameCharacter;

/**
 * A class representing a healing consumable item.
 */
public class ConsumableHealingItem extends Item implements Consumable {

    private final int healingAmount;

    public ConsumableHealingItem(String name, String description, int healingAmount){
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

    /**
     * A method for increasing the character's currentHealth.
     * @param consumer the character consuming the item
     */
    @Override
    public void consume(GameCharacter consumer){
        consumer.setCurrentHealth(Math.min(this.healingAmount + consumer.getCurrentHealth(), consumer.getMaxHealth()));

        // TODO: remove the healing item from the inventory (either when we call consume or through an inventory class)
    }

}
