package combat_system;

import constants.Constants;

import java.util.Map;
/**
 * A map of item name -> StatusEffect object. Since all the StatusEffect are already made,
 * we will use STATUS_LIST in Constants.java.
 */
public class StatusList {
    private final Map<String, StatusEffect> statusList = Constants.STATUS_LIST;


    public StatusEffect getStatus(String statusName){
        return statusList.get(statusName);
    }
}
