package items;
import constants.Constants;

import java.util.Map;

/**
 * A map of item name -> Item object. Since all the Items are already made, we will use ITEMS in Constants.java.
 */
public class ItemList {
    private final Map<String, Item> items = Constants.ITEM_LIST;


    public Item getItem(String itemName){
        return items.get(itemName);
    }
}
