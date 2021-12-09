package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChoiceHandler implements ActionListener {
    MainFrame frame;
    public ChoiceHandler(MainFrame frame) {
        this.frame = frame;
    }

    /**
     * This determines what button was clicked and what to do when the button was clicked.
     * @param event when the button is clicked
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();
        switch(yourChoice) {
            case "c1": frame.displayTravelOptions(frame.sceneManager.getTravelOptions(frame.currentScene)); break;
            case "c2": frame.displayNpcs(frame.sceneManager.getNPC(frame.currentScene)); break;
            case "c3": frame.displayItems(frame.sceneManager.getItems(frame.currentScene)); break;
            case "c4": frame.combatFrame(); break;
            case "c5": frame.save(); break;
        }
    }
}