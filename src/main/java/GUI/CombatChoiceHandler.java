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

    /**
     * This determines what button was clicked and what to do when the button was clicked.
     * @param event when the button is clicked
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();
        switch(yourChoice) {
            case "c1": combat.attack(frame); break;
            case "c2": combat.defend(frame); break;
            case "c3": combat.ability(frame); break;
            case "c4": combat.inventory(frame); break;
            case "c5": combat.nextTurn(frame); break;
        }
    }
}
