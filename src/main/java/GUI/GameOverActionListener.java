package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameOverActionListener implements ActionListener {
    MainFrame frame;

    public GameOverActionListener(MainFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent event) { frame.window.dispose();}
}
