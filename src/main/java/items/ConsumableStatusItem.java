package items;

import characters.GameCharacter;

/**
 * An class representing a healing consumable item.
 */
public class ConsumableStatusItem extends Item implements Consumable{

    private final String statusType;

    public ConsumableStatusItem(String name, String description, String statusType){
        super(name, description);
        this.statusType = statusType;
    }

    public String getStatusType(){
        return this.statusType;
    }

    @Override
    public void consume(GameCharacter consumer){
        if (consumer.getStatusEffects().containsKey(this.statusType)){
                consumer.getStatusEffects().remove(this.statusType);
            // TODO: remove the item from the inventory here or from inventory manager!
        } else {
            System.out.println("This cannot be consumed!");
        }

        // TODO: change how the item is chosen to be consumed when we implement status: maybe we do the
        //  check through the inventory instead?
    }

}