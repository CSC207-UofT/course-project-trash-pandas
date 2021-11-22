package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChoiceHandler implements ActionListener {
    Frame frame;
    public ChoiceHandler(Frame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();
        switch(yourChoice) {
            case "c1": frame.displayTravelOptions(frame.currentScene.getConnectedAreas()); break;
            case "c2": frame.displayDialogue(frame.currentScene.getNpc()); break;
            case "c3": frame.displayItems(frame.currentScene.getItems()); break;
            case "c4": frame.currentScene.start_combat(frame.player.getCharacter()); break;
        }
    }
}