package characters;

import combat_system.StatusEffect;

import java.util.ArrayList;
import java.util.List;

public class Ability {
    private final String name;
    private final List<StatusEffect> effects;
    private final int duration;
    private String combatText, reset;

    public Ability(String name, List<StatusEffect> effects, int duration, String combatText) {
        this.name = name;
        this.effects = effects;
        this.duration = duration;
        this.combatText = combatText;
    }
    public String getName() {return this.name;}

    public List<StatusEffect> getEffects() {return this.effects;}

    public int getDuration() {return this.duration;}

    /**
     * Assumes that the combat text contains NAME anywhere that the user would like the name of the target to be
     * @param name name of the target
     */
    public void setCombatTextTarget(String name) {
        combatText = combatText.replaceAll("NAME", name);
        reset = name;
    }

    /**
     * This resets the combat text after an ability is used so the same name is not stuck with the ability forever
     */
    public void resetCombatText() {
        combatText = combatText.replaceAll(reset, "NAME");
    }

    public String getCombatText() {return this.combatText;}
}
