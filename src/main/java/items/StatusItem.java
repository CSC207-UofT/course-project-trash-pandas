package items;

import characters.GameCharacter;
import combat_system.StatusEffect;

/**
 * An class representing a healing consumable item.
 */
public class StatusItem extends Item {

    private final String statusType;

    public StatusItem(String name, String description, String statusType){
        super(name, description);
        this.statusType = statusType;
    }

    public String getStatusType(){
        return this.statusType;
    }


}