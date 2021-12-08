package characters;

import java.util.ArrayList;
import java.util.HashMap;

import combat_system.StatusEffect;
import items.ArmorItem;
import items.WeaponItem;

import constants.Constants;

/**
 * An abstract class representing a character in the game.
 * Characters include both player and non-player characters
 */
public abstract class GameCharacter {

    private int maxHealth;
    private int currentHealth;
    private final HashMap<StatusEffect, Integer> statusEffects = new HashMap<>();
    private final String name;
    private WeaponItem weapon;
    private ArmorItem armor;
    private ArrayList<Ability> abilities = new ArrayList<>();
    private int attackModifier = 0;
    private int defenseModifier = 0;

    public GameCharacter(int hp, String name){
        this.maxHealth = hp;
        this.currentHealth = hp;
        this.name = name;

        this.weapon = Constants.DEFAULT_WEAPON;
        this.armor = Constants.DEFAULT_ARMOR;
    }

    /**
     * Gets the name of the GameCharacter.
     * @return the name of the GameCharacter
     */
    public String getName() {
        return name;
    }

    public ArrayList<Ability> getAbilities() {return this.abilities;}

    public void addAbility(Ability ability) {this.abilities.add(ability);}


    /**
     * Gets the current health of the GameCharacter.
     * @return the current health of the GameCharacter
     */
    public int getCurrentHealth(){
        return this.currentHealth;
    }

    /**
     * Sets the health of the GameCharacter.
     * @param currentHealth the new health of the GameCharacter
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Changes the health of the GameCharacter by a specified amount.
     * @param addedHealth the health to be added to the GameCharacter
     */
    public void changeCurrentHealth(int addedHealth) {
        this.currentHealth += addedHealth;
    }

    public void changeAttackModifier(int damage) {
        this.attackModifier += damage;
    }

    public void changeDefenseModifier(int armor) {
        this.defenseModifier += armor;
    }

    /**
     * Gets the max health of the GameCharacter.
     * @return the max health of the GameCharacter
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Sets the max health of the GameCharacter.
     * @param maxHealth the new max health of the GameCharacter
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Gets status affects of the GameCharacter.
     * @return the list of status effects affecting the GameCharacter
     */
    public HashMap<StatusEffect, Integer> getStatusEffects(){
        return this.statusEffects;
    }

    /**
     * Return if the character has the specified status effect in the list of current status effects.
     * @param statusEffect the status effect to look for
     * @return true if statusEffects has the key statusEffect
     */
    public boolean hasStatus(StatusEffect statusEffect){
        return this.statusEffects.containsKey(statusEffect);
    }

    /**
     * Sets a new status effect for the characters.GameCharacter.statusEffects
     * @param status the new status to add to characters.GameCharacter.statusEffects
     * @param duration the duration that the status will last for in rounds
     */
    public void setStatusEffect(StatusEffect status, Integer duration){
        this.statusEffects.put(status, duration);
    }

    /**
     * Removes a currently afflicted status effect.
     * @param status the status effect to be removed
     */
    public void removeStatusEffect(StatusEffect status){
        this.statusEffects.remove(status);
    }

    /**
     * Gets the currently equipped weapon of the GameCharacter.
     * @return the currently equipped weapon of the GameCharacter
     */
    public WeaponItem getWeapon() {
        return this.weapon;
    }

    /**
     * Set the weapon attribute to the specified weapon.
     * @param newWeapon the new WeaponItem stored in the weapon attribute
     */
    public void setWeapon(WeaponItem newWeapon){
        this.weapon = newWeapon;
    }

    /**
     * Gets the currently equipped armor of the GameCharacter.
     * @return the currently equipped armor of the GameCharacter
     */
    public ArmorItem getArmor() {
        return this.armor;
    }

    /**
     * Set the armor attribute to the specified armor.
     * @param newArmor the new ArmorItem stored in the armor attribute
     */
    public void setArmor(ArmorItem newArmor){
        this.armor = newArmor;
    }

    /**
     * Return the equipped armor's defense value.
     * @return the defense value
     */
    public int getArmorDefense(){
        return Math.max(this.armor.getDefense() + this.defenseModifier, 0);
    }

    /**
     * Return the equipped armor's bonus health value.
     * @return the defense value
     */
    public int getArmorBonusHealth(){
        return this.armor.getBonusHealth();
    }

    /**
     * Return the equipped weapon's damage value.
     * @return the defense value
     */
    public int getWeaponDamage(){
        return Math.max(this.weapon.getDamage() + this.attackModifier, 0);
    }

    //TODO: make a tostring for gamecharacter
}
