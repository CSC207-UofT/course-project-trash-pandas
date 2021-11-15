package constants;

import combat_system.StatusEffect;
import items.Item;
import items.ArmorItem;
import items.QuestItem;
import items.WeaponItem;

import java.util.Map;
import java.util.Set;

public class Constants {

    public static final ArmorItem DEFAULT_ARMOR = new ArmorItem("Unarmoured",
            "An almost non-existent layer of protection.",
            1,
            0);

    public static final WeaponItem DEFAULT_WEAPON = new WeaponItem("Unarmed",
            "You attack with your appendages.",
            1);

    public static final Set<Item> CANNOT_BE_ADDED = Set.of(DEFAULT_ARMOR, DEFAULT_WEAPON);

    public static final Map<String, Item> ITEMS = Map.ofEntries(Map.entry("coin", new QuestItem("coin",
            "a silver coin"))

    );

    public static final Map<String, StatusEffect> STATUS_LIST = Map.ofEntries(

    );
}
