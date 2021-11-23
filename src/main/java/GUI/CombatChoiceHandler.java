package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatChoiceHandler implements ActionListener {
    MainFrame frame;
    public CombatChoiceHandler(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();
        switch(yourChoice) {
            case "c1": break;
            case "c2": break;
            case "c3": break;
            case "c4": break;
        }
    }
}
