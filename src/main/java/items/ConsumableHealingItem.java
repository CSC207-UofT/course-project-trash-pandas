package items;

/**
 * A class representing a healing consumable item.
 */
public class ConsumableHealingItem extends Item implements Consumable {

    private int healingAmount;

    public ConsumableHealingItem(String name, String description, int healingAmount){
        super(name, description);
        this.healingAmount = healingAmount;
    }

    /**
     * A method for increasing the character's currentHealth.
     * @param consumer the character consuming the item
     */
    public void consume(GameCharacter consumer){
        if (this.healingAmount + consumer.getCurrentHealth() >= consumer.getMaxHealth()){
            consumer.setCurrentHealth(consumer.getMaxHealth());
        }
        else{
            consumer.setCurrentHealth(consumer.getCurrentHealth() + this.healingAmount);
        }

        // TODO: remove the healing item from the inventory (either when we call consume or through an inventory class)
    }

}
