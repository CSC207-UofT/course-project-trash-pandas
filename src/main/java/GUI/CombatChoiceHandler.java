package GUI;

import combat_system.Combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatChoiceHandler implements ActionListener {
    MainFrame frame;
    Combat combat;
    public CombatChoiceHandler(MainFrame frame) {
        this.frame = frame;
        this.combat=frame.currentScene.getCombat(frame.player);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();
        switch(yourChoice) {
            case "c1": combat.attack(frame); System.out.println(combat.secondStage); break;
            case "c2": combat.defend(frame); System.out.println(combat.secondStage);break;
            case "c3": combat.ability(frame); System.out.println(combat.secondStage);break;
            case "c4": combat.inventory(frame); System.out.println(combat.secondStage);break;
            case "c5": combat.nextTurn(frame); System.out.println(combat.secondStage);break;
        }
    }
}
