package constants;

import characters.Ability;
import combat_system.StatusEffect;
import items.Item;
import items.ArmorItem;
import items.QuestItem;
import items.WeaponItem;
import combat_system.StatusEffect;

import java.util.ArrayList;
import java.util.List;
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

    // TODO: write descriptions
    public static final Map<String, StatusEffect> STATUS_LIST = Map.ofEntries(
            Map.entry("poison", new StatusEffect("poison", "TEST DESC", List.of("health -1"))),
            Map.entry("blindness", new StatusEffect("blindness", "TEST DESC", List.of("attack -2"))),
            Map.entry("adrenaline", new StatusEffect("adrenaline", "TEST DESC", List.of("attack 1"))),
            Map.entry("turtle", new StatusEffect("turtle", "TEST DESC", List.of("attack -1", "defense 2"))),
            Map.entry("binding", new StatusEffect("binding", "TEST DESC", List.of("attack -10", "defense -1"))),
            Map.entry("berzerk", new StatusEffect("berzerk", "TEST DESC", List.of("health -1", "attack 5", "defense -2")))
    );

    public static final Map<String, Ability> ABILITY_LIST = Map.ofEntries(
        Map.entry("trash", new Ability("Throw trash",
                List.of(STATUS_LIST.get("poison"), STATUS_LIST.get("blindness")), 2, "You threw trash at NAME!")),
        Map.entry("box", new Ability("Hide in a box",
                List.of(STATUS_LIST.get("turtle")), 3, "You hid NAME in a box!")),
        Map.entry("sand", new Ability("Kick up some sand",
                List.of(STATUS_LIST.get("blindness"), STATUS_LIST.get("adrenaline")), 5, "You kicked sand into NAME's eyes!"))
    );
}
