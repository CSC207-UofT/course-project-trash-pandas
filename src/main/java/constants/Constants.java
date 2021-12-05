package constants;

import combat_system.StatusEffect;
import items.Item;
import items.ArmorItem;
import items.QuestItem;
import items.WeaponItem;

import java.util.Map;
import java.util.Set;

public class Constants {
    // the default armor
    public static final ArmorItem DEFAULT_ARMOR = new ArmorItem("Unarmoured",
            "An almost non-existent layer of protection.",
            1,
            0);
    //the default weapon
    public static final WeaponItem DEFAULT_WEAPON = new WeaponItem("Unarmed",
            "You attack with your appendages.",
            1);
    //items that cannot be added to the inventory
    public static final Set<Item> CANNOT_BE_ADDED = Set.of(DEFAULT_ARMOR, DEFAULT_WEAPON);
    /**
     * A map of all the items in the game. The keys are the item names and the values are the Item objects.
     */
    public static final Map<String, Item> ITEM_LIST = Map.ofEntries(
            Map.entry("coin", new QuestItem("coin", "a silver coin")),
            Map.entry("dirty claws", new WeaponItem("Dirty Claws",
                    "A pair of claws covered in grime and gunk from the sewers",
                    3)),
            Map.entry("sharp knife", new WeaponItem("Sharp Knife",
                    "a sharp knife that can be used for stabbing or slashing",
                    5)),
            Map.entry("trash can lid", new WeaponItem("Trash Can Lid",
                    "A trash can lid that has an odd resemblence to Captain America's shield.",
                    8)),
            Map.entry("giant trash bag", new WeaponItem("Giant Trash Bag",
                    "a giant trash bag filled to the brim. Hitting someone over the head with it must hurt.",
                    10)),
            Map.entry("sewage sword", new WeaponItem("Sewage Sword",
                    "a sword retrieved from the sewer system. It smells disgusting and looks horrendous, but contains unimaginable power.",
                    15))
    );
    // list of all the status effects
    public static final Map<String, StatusEffect> STATUS_LIST = Map.ofEntries(

    );
}
