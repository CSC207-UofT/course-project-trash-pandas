package GUI;

import characters.Ability;
import characters.NonPlayerCharacter;
import combat_system.Combat;
import combat_system.StatusEffect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatInputListener implements ActionListener {
    MainFrame frame;
    Combat combat;
    Boolean secondStage = false;
    Ability savedAbility;

    public CombatInputListener(MainFrame frame) {
        this.frame = frame;
        this.combat = frame.currentScene.getCombat(frame.player);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String input = frame.combatField.getText();

        boolean valid = false;
        System.out.println(combat.attack);
        if(input.equalsIgnoreCase("Back")) {
            valid = true;
            frame.displayCombatText("What would you like to do?");
        }
        else if(combat.attack) {
            for (NonPlayerCharacter target: combat.findAliveNpcs()) {
                if(target.getName().equalsIgnoreCase(input)){
                    frame.displayCombatText(combat.damage(combat.rollAttack(), target,
                            combat.findPlayer().getCharacter().getCharacter()));
                    frame.displayCombatInput("You attack " + target.getName());
                    valid = true;
                    combat.attack = false;
                    break;
                }
            }
        }
        else if (secondStage) {
            for (NonPlayerCharacter npc: combat.findAliveNpcs()) {
                if (npc.getName().equalsIgnoreCase(input)) {
                    savedAbility.setCombatTextTarget(npc.getName());
                    frame.displayCombatText(savedAbility.getCombatText());
                    for (StatusEffect effect : savedAbility.getEffects()) {
                        combat.effectFacade.apply(npc, effect, savedAbility.getDuration()); // TODO: clean up
                    }
                    valid = true;
                    secondStage = false;
                    savedAbility = null;
                }
            }
        }
        else if(combat.ability) { // make these have their own methods
            for (Ability ability: combat.findPlayer().getCharacter().getCharacter().getAbilities()) {
                if (ability.getName().equalsIgnoreCase(input)) {
                    StringBuilder targets = new StringBuilder("Who would you like to use " + input + " on?");
                    for (NonPlayerCharacter npc: combat.findAliveNpcs()) {
                        targets.append("\n").append(npc.getName());
                    }
                    frame.displayCombatText(targets.toString());
                    valid = true;
                    combat.ability = false;
                    frame.combatField.setText("Write Target");
                    secondStage = true;
                    break;
                }
            }
        }
        else if (combat.inventory) {
            if(combat.findPlayer().getInventory().contains(input)) {
                frame.displayCombatText("You use " + input);
                combat.findPlayer().consumeItem(input);
                valid = true;
                combat.inventory = false;
            }
        }
    }
}