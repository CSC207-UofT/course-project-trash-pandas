package characters;
//
//import characters.GameCharacter;
//import org.json.simple.JSONObject;
//import quest_system.Quest;

import java.util.HashMap;
import java.util.Map;

import combat_system.*;
import items.*;
import constants.*;

/**
 * Manages a specified character.
 */
public class CharacterManager {
    //
//    private InventoryChange changer;
    private HashMap<String, NonPlayerCharacter> npcs = new HashMap<>();
    private PlayerCharacter player;
    private final GameCharacter character;
    private final ItemList itemList = new ItemList();
    private final StatusList statusList = new StatusList();

    public CharacterManager(GameCharacter character) {
        this.character = character;
    }

    /**
     * Heal the character for the amount specified in the healing item, or to the character's maxHP, depending on which
     * one is lower.
     *
     * @param itemName the name of the healing item
     */
    public void consumeHeal(String itemName) {
        HealingItem item = (HealingItem) itemList.getItem(itemName);
        character.setCurrentHealth(
                Math.min(character.getCurrentHealth() + item.getHealingAmount(),
                        character.getMaxHealth()));
    }

    /**
     * Remove the statusEffect specified by the item from the character instance.
     *
     * @param itemName the name of the StatusItem
     */
    public void consumeStatus(String itemName) {
        StatusItem item = (StatusItem) itemList.getItem(itemName);
        StatusEffect statusEffect = statusList.getStatus(item.getStatusType());
        character.removeStatusEffect(statusEffect);

    }

    public GameCharacter getCharacter() {
        return this.character;
    }


    /**
     * Reduce the maxHealth and currentHealth if it was modified by the previous armor.
     * Change the armor to the default armor.
     */
    public void unequipArmor() {
        character.setMaxHealth(character.getMaxHealth() - character.getArmorBonusHealth());
        character.setCurrentHealth(
                Math.max(character.getCurrentHealth() - character.getArmorBonusHealth(), 1));
        character.setArmor(Constants.DEFAULT_ARMOR);
    }

    /**
     * Modify the weapon attribute of character and set it to DEFAULT_WEAPON.
     */
    public void unequipWeapon() {
        this.character.setWeapon(Constants.DEFAULT_WEAPON);
    }

    /**
     * Modify the armor attribute of character to the new armor and update the health values accordingly.
     * This assumes that the default armor is equipped.
     *
     * @param newArmorName the name of the new armor to be equipped
     */
    public void equipArmor(String newArmorName) {
        ArmorItem newArmor = (ArmorItem) itemList.getItem(newArmorName);
        this.character.setMaxHealth(this.character.getMaxHealth() + this.character.getArmorBonusHealth());
        if (this.character.getCurrentHealth() != 0) {
            this.character.setCurrentHealth(this.character.getCurrentHealth() + this.character.getArmorBonusHealth());
        }

        this.character.setArmor(newArmor);
    }

    /**
     * Modify the weapon attribute of character to the specified weapon.
     *
     * @param newWeaponName the name of the new weapon to be equipped
     */
    public void equipWeapon(String newWeaponName) {
        WeaponItem newWeapon = (WeaponItem) itemList.getItem(newWeaponName);
        this.character.setWeapon(newWeapon);
    }

    public void setStatusEffect(String statusName, int duration) {
        StatusEffect statusEffect = statusList.getStatus(statusName);
        if (duration > 0) {
            character.setStatusEffect(statusEffect, duration);
        } else {
            character.removeStatusEffect(statusEffect);
        }

    }

    public String getName(){
        return this.character.getName();
    }
}
//    public Object getNpcs() {
//        return new JSONObject(this.npcs);
//
//}
