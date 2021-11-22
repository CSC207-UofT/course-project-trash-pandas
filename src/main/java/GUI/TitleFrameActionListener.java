package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TitleFrameActionListener implements ActionListener {
    MainFrame frame;

    public TitleFrameActionListener(MainFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        frame.gameFrame();
    }
}
