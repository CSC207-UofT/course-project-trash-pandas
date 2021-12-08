package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameOverActionListener implements ActionListener {
    MainFrame frame;

    /**
     * Very simple button that closes the game
     * @param frame the window that is currently open
     */
    public GameOverActionListener(MainFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent event) { frame.window.dispose();}
}
