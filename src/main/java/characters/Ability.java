package characters;

import combat_system.StatusEffect;

import java.util.ArrayList;

public class Ability {
    private final String name;
    private final ArrayList<StatusEffect> effects;
    private final int duration;
    private String combatText;

    Ability(String name, ArrayList<StatusEffect> effects, int duration, String combatText) {
        this.name = name;
        this.effects = effects;
        this.duration = duration;
        this.combatText = combatText;
    }
    public String getName() {return this.name;}

    public ArrayList<StatusEffect> getEffects() {return this.effects;}

    public int getDuration() {return this.duration;}

    /**
     * Assumes that the combat text contains NAME anywhere that the user would like the name of the target to be
     * @param name
     */
    public void setCombatTextTarget(String name) {
        combatText = combatText.replaceAll("NAME", name);
    }

    public String getCombatText() {return this.combatText;}
}
