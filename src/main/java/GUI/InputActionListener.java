package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InputActionListener implements ActionListener {
    MainFrame frame;
    public InputActionListener(MainFrame frame) {
        this.frame = frame;
    }

    /**
     * Handles what to do when an action is performed.
     * @param event when enter is pressed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String input = frame.entryField.getText();
        boolean valid = false;

        if(input.equalsIgnoreCase("Back")) {
            valid = true;
            frame.displayScene(frame.currentScene);
        }
        else if(frame.search) {
            String i = null;
            for (String item : frame.sceneManager.getItems(frame.currentScene)) {
                if (input.equalsIgnoreCase(item)) {
                    valid = true;
                    frame.entryField.setText("You pick up " + item);
                    frame.mainTextArea.setText("You pick up " + item);
                    frame.player.addItem(item, 1);
                    i = item;
                    frame.search = false;
                }
            }
            if(i != null) {
                frame.sceneManager.removeItem(frame.currentScene, i);
            }
        }
        else if(frame.travel) {
            for(String sc: frame.sceneManager.getTravelOptions(frame.currentScene)) {
                if(input.equalsIgnoreCase(sc)) {
                    valid = true;
                    frame.entryField.setText("You traveled to " + sc);
                    frame.displayScene(sc);
                    frame.travel = false;
                }
            }
        }
        else if(frame.talk) {
            for(String npc: frame.sceneManager.getNPC(frame.currentScene)) {
                if(input.equalsIgnoreCase(npc)) {
                    valid = true;
                    frame.mainTextArea.setText(frame.cifManager.getDialogue(npc));
                    frame.entryField.setText("You talked to " + npc);
                    frame.talk = false;
                }
            }
        }
        if(!valid) {
            frame.entryField.setText("Not a valid entry, please try again");
        }
    }
}
