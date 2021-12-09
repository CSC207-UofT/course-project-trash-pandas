package constants;

import characters.Ability;
import combat_system.StatusEffect;
import items.*;

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
                    15)),
            Map.entry("ragged clothes I", new ArmorItem("Ragged Clothes I",
                    "a tattered and dirty shirt. It looks like it provides a little bit of protection.",
                    3,
                    5)),
            Map.entry("ragged clothes II", new ArmorItem("Ragged Clothes II",
                    "a tattered and dirty pair of shorts. It looks like it provides a little bit of protection.",
                    5,
                    3)),
            Map.entry("trash bag dress I", new ArmorItem("Trash Bag Dress I",
                    "a long dress made out of trash bags. It looks comfy and stylish.",
                    6,
                    10)),
            Map.entry("trash bag dress II", new ArmorItem("Trash Bag Dress II",
                    " a short dress made out of trash bags. It looks comfy and stylish.",
                    10,
                    6)),

            Map.entry("rubbish robes I", new ArmorItem("Rubbish Robes I",
                    "a wizard-like robe made from recycled material. It makes you feel powerful.",
                    11,
                    15)),
            Map.entry("rubbish robes II", new ArmorItem("Rubbish Robes II",
                    "a monk-like robe made from recycled material. It makes you feel powerful",
                    16,
                    11)),
            Map.entry("reinforced armor I", new ArmorItem("Foil-Reinforced Armor I",
                    "a set of armor reinforced by aluminum foil. It provides a strong layer of protection.",
                    17,
                    21)),
            Map.entry("reinforced armor II", new ArmorItem("Foil-Reinforced Armor II",
                    "a set of armor reinforced by scrap metal. It provides a strong layer of protection.",
                    22,
                    15)),
            Map.entry("ancient dweller armor I", new ArmorItem("Ancient Dweller Armor I",
                    "armor worn by the rat ancestors 200 years ago. The perfect armor.",
                    25,
                    30)),
            Map.entry("ancient dweller armor II", new ArmorItem("Ancient Dweller Armor II",
                    "armor worn by the raccoon ancestors 200 years ago. The perfect armor.",
                    32,
                    25)),

            Map.entry("potion", new HealingItem("Potion",
                    "A consumable object that can be used to restore 5HP",
                    5)),
            Map.entry("super potion", new HealingItem("Super Potion",
                    "A consumable object that can be used to restore 10HP",
                    10)),
            Map.entry("hyper potion", new HealingItem("Hyper Potion",
                    "A consumable object that can be used to restore 15HP",
                    15))
    );

    // list of all the status effects

    // TODO: write descriptions
    public static final Map<String, StatusEffect> BUFF_LIST = Map.ofEntries(
            Map.entry("adrenaline", new StatusEffect("adrenaline", "TEST DESC", List.of("attack 1"))),
            Map.entry("turtle", new StatusEffect("turtle", "TEST DESC", List.of("attack -1", "defense 2"))),
            Map.entry("berzerk", new StatusEffect("berzerk", "TEST DESC", List.of("health -1", "attack 5", "defense -2")))
    );

    public static final Map<String, StatusEffect> DEBUFF_LIST = Map.ofEntries(
            Map.entry("poison", new StatusEffect("poison", "TEST DESC", List.of("health -1"))),
            Map.entry("blindness", new StatusEffect("blindness", "TEST DESC", List.of("attack -2"))),
            Map.entry("binding", new StatusEffect("binding", "TEST DESC", List.of("attack -10", "defense -1")))
    );

    public static final Map<String, Ability> ABILITY_LIST = Map.ofEntries(
        Map.entry("trash", new Ability("Throw trash",
                List.of(DEBUFF_LIST.get("poison"), DEBUFF_LIST.get("blindness")), 2, "You threw trash at NAME!")),
        Map.entry("box", new Ability("Hide in a box",
                List.of(BUFF_LIST.get("turtle")), 3, "You hid NAME in a box!")),
        Map.entry("sand", new Ability("Kick up some sand",
                List.of(BUFF_LIST.get("blindness"), BUFF_LIST.get("adrenaline")), 5, "You kicked sand into NAME's eyes!"))
    );
}
