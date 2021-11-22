package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TitleFrameActionListener implements ActionListener {
    Frame frame;

    public TitleFrameActionListener(Frame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        frame.mainFrame();
    }
}
