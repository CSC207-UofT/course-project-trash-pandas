package characters;

import combat_system.StatusEffect;
import constants.Constants;
import items.ArmorItem;
import items.WeaponItem;
import junit.framework.TestCase;
import quest_system.CombatQuest;
import quest_system.Quest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class NonPlayerCharacterTest extends TestCase {
    private NonPlayerCharacter npc;
    private NonPlayerCharacter target;
    private CombatQuest cq;

    public void setUp(){
        this.target = new NonPlayerCharacter(10, "target");
        this.cq = new CombatQuest("kill", Set.of(target));
        this.npc = new NonPlayerCharacter(10, "npc", "a", "b", "c", cq, "combat");
    }

    public void tearDown(){
        this.target = null;
        this.npc = null;
        this.cq = null;
    }

    public void testAddAbility() {
        this.npc.addAbility(Constants.ABILITY_LIST.get("trash"));
        ArrayList<Ability> abilities = new ArrayList<>();
        abilities.add(Constants.ABILITY_LIST.get("trash"));
        assertEquals(abilities, npc.getAbilities());
    }

    public void testSetCurrentHealth() {
        this.npc.setCurrentHealth(5);
        assertEquals(5,npc.getCurrentHealth());
    }

    public void testChangeCurrentHealth() {
        this.npc.changeCurrentHealth(5);
        assertEquals(15,npc.getCurrentHealth());
    }

    public void testChangeAttackModifier() {
        this.npc.changeAttackModifier(5);
        assertEquals(6,this.npc.getWeaponDamage());

    }

    public void testChangeDefenseModifier() {
        this.npc.changeDefenseModifier(5);
        assertEquals(6,this.npc.getArmorDefense());
    }

    public void testSetMaxHealth() {
        this.npc.setMaxHealth(15);
        assertEquals(15,this.npc.getMaxHealth());
    }

    public void testHasStatus() {
        StatusEffect effect = Constants.STATUS_LIST.get("poision");
        this.npc.setStatusEffect(effect, 2);
        assertTrue(this.npc.hasStatus(effect));
        HashMap<StatusEffect,Integer> effects = new HashMap<>();
        effects.put(effect, 2);
        assertEquals(effects,this.npc.getStatusEffects());
        this.npc.removeStatusEffect(effect);
        assertFalse(this.npc.hasStatus(effect));
    }

    public void testSetWeapon() {
        this.npc.setWeapon((WeaponItem) Constants.ITEM_LIST.get("dirty claws"));
        assertEquals(Constants.ITEM_LIST.get("dirty claws"),this.npc.getWeapon());
    }

    public void testSetArmor() {
        this.npc.setArmor((ArmorItem) Constants.ITEM_LIST.get("ragged clothes I"));
        assertEquals(Constants.ITEM_LIST.get("ragged clothes I"), npc.getArmor());
    }

    public void testGetQuest() {
        assertEquals(this.cq,this.npc.getQuest());
    }

    public void testGetQuestDialogue() {
        assertEquals("npc: a", npc.getQuestDialogue(0));
    }

    public void testGetCombatDialogue() {
        assertEquals("npc: combat",npc.getCombatDialogue());
    }

    public void testGetName(){
        assertEquals("npc", npc.getName());
    }

    public void testGetArmour(){
        assertEquals(0, npc.getArmorBonusHealth());
    }
}