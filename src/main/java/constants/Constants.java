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
            Map.entry("coin", new QuestItem("coin", "A silver coin")),
            Map.entry("dirty claws", new WeaponItem("Dirty Claws",
                    "A pair of claws covered in grime and gunk from the sewers.",
                    3)),
            Map.entry("sharp knife", new WeaponItem("Sharp Knife",
                    "A sharp knife that can be used for stabbing or slashing.",
                    5)),
            Map.entry("trash can lid", new WeaponItem("Trash Can Lid",
                    "A trash can lid that has an odd resemblence to Captain America's shield.",
                    8)),
            Map.entry("giant trash bag", new WeaponItem("Giant Trash Bag",
                    "A giant trash bag filled to the brim. Hitting someone over the head with it must hurt.",
                    10)),
            Map.entry("sewage sword", new WeaponItem("Sewage Sword",
                    "A sword retrieved from the sewer system. It smells disgusting and looks horrendous, but contains unimaginable power.",
                    15)),
            Map.entry("ragged clothes I", new ArmorItem("Ragged Clothes I",
                    "A tattered and dirty shirt. It looks like it provides a little bit of protection.",
                    3,
                    5)),
            Map.entry("ragged clothes II", new ArmorItem("Ragged Clothes II",
                    "A tattered and dirty pair of shorts. It looks like it provides a little bit of protection.",
                    5,
                    3)),
            Map.entry("trash bag dress I", new ArmorItem("Trash Bag Dress I",
                    "A long dress made out of trash bags. It looks comfy and stylish.",
                    6,
                    10)),
            Map.entry("trash bag dress II", new ArmorItem("Trash Bag Dress II",
                    "A short dress made out of trash bags. It looks comfy and stylish.",
                    10,
                    6)),
            Map.entry("rubbish robes I", new ArmorItem("Rubbish Robes I",
                    "A wizard-like robe made from recycled material. It makes you feel powerful.",
                    11,
                    15)),
            Map.entry("rubbish robes II", new ArmorItem("Rubbish Robes II",
                    "A monk-like robe made from recycled material. It makes you feel powerful.",
                    16,
                    11)),
            Map.entry("reinforced armor I", new ArmorItem("Foil-Reinforced Armor I",
                    "A set of armor reinforced by aluminum foil. It provides a strong layer of protection.",
                    17,
                    21)),
            Map.entry("reinforced armor II", new ArmorItem("Foil-Reinforced Armor II",
                    "A set of armor reinforced by scrap metal. It provides a strong layer of protection.",
                    22,
                    15)),
            Map.entry("Ancient dweller armor I", new ArmorItem("Ancient Dweller Armor I",
                    "Armor worn by the rat ancestors 200 years ago. The perfect armor.",
                    25,
                    30)),
            Map.entry("Ancient dweller armor II", new ArmorItem("Ancient Dweller Armor II",
                    "Armor worn by the raccoon ancestors 200 years ago. The perfect armor.",
                    32,
                    25))
    );

    // List of all the status effects

    public static final Map<String, StatusEffect> STATUS_LIST = Map.ofEntries(
            Map.entry("poison", new StatusEffect("poison", List.of("health -1"))),
            Map.entry("blindness", new StatusEffect("blindness", List.of("attack -2"))),
            Map.entry("adrenaline", new StatusEffect("adrenaline", List.of("attack 1"))),
            Map.entry("turtle", new StatusEffect("turtle", List.of("attack -1", "defense 2"))),
            Map.entry("binding", new StatusEffect("binding", List.of("attack -10", "defense -1"))),
            Map.entry("berzerk", new StatusEffect("berzerk", List.of("health -1", "attack 5", "defense -2")))
    );

    public static final Map<String, Ability> ABILITY_LIST = Map.ofEntries(
        Map.entry("trash", new Ability("Throw trash",
                List.of(STATUS_LIST.get("poison"), STATUS_LIST.get("blindness")), 2, "USER threw trash at NAME!")),
        Map.entry("box", new Ability("Hide in a box",
                List.of(STATUS_LIST.get("turtle")), 3, "USER hid NAME in a box!")),
        Map.entry("sand", new Ability("Kick up some sand",
                List.of(STATUS_LIST.get("blindness"), STATUS_LIST.get("adrenaline")), 5, "USER kicked sand into NAME's eyes!"))
    );
}
