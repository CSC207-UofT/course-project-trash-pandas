package GUI;

import combat_system.Combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatChoiceHandler implements ActionListener {
    MainFrame frame;
    Combat combat;
    public CombatChoiceHandler(MainFrame frame) {
        this.frame = frame;
        System.out.print(frame.player.getCharacter().getCharacter().getName());
        this.combat=frame.currentScene.getCombat(frame.player);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();
        switch(yourChoice) {
            case "c1": combat.attack(frame); break;
            case "c2": combat.defend(frame); break;
            case "c3": combat.ability(frame); break;
            case "c4": combat.inventory(frame); break;
        }
    }
}
