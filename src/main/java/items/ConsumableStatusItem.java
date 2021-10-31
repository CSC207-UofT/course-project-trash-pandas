package items;


/**
 * An class representing a healing consumable item.
 */
public class ConsumableStatusItem extends Item implements Consumable{

    private String statusType;

    public ConsumableStatusItem(String name, String description, String statusType){
        super(name, description);
        this.statusType = statusType;
    }

    public String getStatusType(){
        return this.statusType;
    }

    public void consume(Character consumer){
        if (this.statusType == consumer.getStatus){
            consumer.setStatus('normal');
            // TODO: remove the item from the inventory here!
        } else {
            System.out.println("This cannot be consumed!");
        }

        // TODO: change how the item is chosen to be consumed when we implement status: maybe we do the
        //  check through the inventory instead?
    }

}