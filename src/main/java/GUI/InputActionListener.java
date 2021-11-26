package GUI;

import characters.CharacterInventoryFacade;
import characters.NonPlayerCharacter;
import items.Item;
import scene_system.DisplayDialogue;
import scene_system.Scene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InputActionListener implements ActionListener {
    MainFrame frame;
    public InputActionListener(MainFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        String input = frame.entryField.getText();
        boolean valid = false;

        if(input.equalsIgnoreCase("Back")) {
            valid = true;
            frame.displayScene(frame.currentScene);
        }
        else if(frame.search) {
            Item i = null;
            for (Item item : frame.currentScene.getItems()) {
                if (input.equalsIgnoreCase(item.getName())) {
                    valid = true;
                    frame.entryField.setText("You pick up " + item.getName());
                    frame.mainTextArea.setText("You pick up " + item.getName());
                    frame.player.addItem(item.getName(), 1);
                    i = item;
                    frame.search = false;
                }
            }
            if(i != null) {
                frame.currentScene.removeItem(i);
            }
        }
        else if(frame.travel) {
            for(Scene sc: frame.currentScene.getConnectedAreas()) {
                if(input.equalsIgnoreCase(sc.getName())) {
                    valid = true;
                    frame.entryField.setText("You traveled to " + sc.getName());
                    frame.displayScene(sc);
                    frame.travel = false;
                }
            }
        }
        else if(frame.talk) {
            for(CharacterInventoryFacade npc: frame.currentScene.getNpc()) {
                if(input.equalsIgnoreCase(npc.getCharacter().getCharacter().getName())) {
                    valid = true;
                    DisplayDialogue disp = new DisplayDialogue();
                    frame.mainTextArea.setText(disp.dialogue((NonPlayerCharacter) npc.getCharacter().getCharacter(), frame.player));
                    frame.entryField.setText("You talked to " + npc.getCharacter().getCharacter().getName());
                    frame.talk = false;
                }
            }
        }
        if(!valid) {
            frame.entryField.setText("Not a valid entry, please try again");
        }
    }
}
