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


    /** returns a string description of the ability with the target
     *
     * @param target a string representing the name of the target
     * @return the combat text with name as a target
     */
    public String getCombatText(String user, String target) {
        String text = combatText.replaceAll("NAME", target);
        return text.replaceAll("USER",user);

    }
}
