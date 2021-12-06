package combat_system;

import characters.GameCharacter;

import java.util.List;
import java.util.Map;

// TODO: add javadoc besides the ones i stole from george

/**
 * A facade class that provides a unified interface for Characters and StatusEffect interactions.
 * All handling of status effects during combat occurs here.
 */
public class CharacterStatusEffectFacade {

    /**
     * Applies a status effect to a given target.
     * If the target is already afflicted by the status effect,
     * it will be reapplied if the remaining duration is lower than the new duration.
     * @param target a reference to the target of the status effect
     * @param effect the status effect to apply
     * @param duration the duration of the status effect to apply
     */
    public void apply(GameCharacter target, StatusEffect effect, int duration) {
        if (target.getStatusEffects().get(effect) == null ||
                target.getStatusEffects().get(effect) < duration) {

            target.setStatusEffect(effect, duration);

            // Handling beginning of persistent subeffects
            for (String subeffect : effect.getSubeffects()) {
                String type = getSubeffectType(subeffect);
                int argument = getSubeffectArgument(subeffect);

                switch (type) {
                    case "damage":
                        changeAttack(target, argument);
                        break;
                    case "armor":
                        changeDefense(target, argument);
                        break;
                }
            }
        }
    }

    /**
     * Processes application of status effects over a single combat turn.
     * Decrements duration for each active effect.
     * @param characters list of characters to be processed
     */
    public void process(List<GameCharacter> characters) {
        for (GameCharacter character : characters) {
            for (Map.Entry<StatusEffect, Integer> entry : character.getStatusEffects().entrySet()) {
                StatusEffect effect = entry.getKey();
                Integer duration = entry.getValue();

                // Decrement status effects
                character.setStatusEffect(effect, duration-1);

                for (String subeffect : effect.getSubeffects()) {
                    String type = getSubeffectType(subeffect);
                    int argument = getSubeffectArgument(subeffect);

                    if (duration == 0) {
                        // Handling ending of persistent subeffects
                        switch (type) {
                            case "damage":
                                changeAttack(character, -argument);
                                break;
                            case "armor":
                                changeDefense(character, -argument);
                                break;
                        }
                    } else {
                        // Handling recurring subeffects
                        switch (type) {
                            case "health":
                                changeHealth(character, argument);
                                break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets type string for subeffect.
     * This represents the type of the subeffect.
     * @param subeffect subeffect to be parsed
     * @return String representing subeffect type
     */
    public String getSubeffectType(String subeffect) {
        return subeffect.split(" ")[0];
    }

    /**
     * Gets argument integer for subeffect.
     * This represents the intensity of the subeffect.
     * @param subeffect subeffect to be parsed
     * @return int representing subeffect intensity
     */
    public int getSubeffectArgument(String subeffect) {
        return Integer.parseInt(subeffect.split(" ")[1]);
    }

    /**
     * Clears all active effects from characters.
     * Used to end combat processing.
     * @param characters the list of characters to have effects cleared from
     */
    public void clear(List<GameCharacter> characters) {
        for (GameCharacter character : characters) {
            for (Map.Entry<StatusEffect, Integer> entry : character.getStatusEffects().entrySet()) {
                character.setStatusEffect(entry.getKey(), 0);
            }
        }
    }

    /**
     * Changes current health for given character.
     * @param character the character to be changed
     * @param health the amount of health to be added
     */
    public void changeHealth(GameCharacter character, int health) {
        character.changeCurrentHealth(health);
    }

    /**
     * Changes attack modifier for given character.
     * @param character the character to be changed
     * @param attack the amount to be added to the modifier
     */
    public void changeAttack(GameCharacter character, int attack) {
        character.changeAttackModifier(attack);
    }

    /**
     * Changes defense modifier for given character.
     * @param character the character to be changed
     * @param defense the amount to be added to the modifier
     */
    public void changeDefense(GameCharacter character, int defense) {
        character.changeDefenseModifier(defense);
    }

}
