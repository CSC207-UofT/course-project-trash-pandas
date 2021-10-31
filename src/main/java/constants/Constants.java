package constants;

import items.Item;
import items.ArmourItem;
import items.WeaponItem;

public class Constants {

    public static final ArmourItem DEFAULT_ARMOR = new ArmourItem("Unarmoured",
            "An almost non-existent layer of protection.",
            1,
            0);

    public static final WeaponItem DEFAULT_WEAPON = new WeaponItem("Unarmed",
            "You attack with your appendages.",
            1);
}
