package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BLogged implements ActionListener {
    Font font;

    public BLogged(Font font) {
        this.font = font;
    }

    public void actionPerformed(ActionEvent pressed) {
        JButton start = (JButton) pressed.getSource();
        start.setFont(font.deriveFont(20f));
        start.setForeground(Color.BLACK);
        start.setBackground(Color.DARK_GRAY);
        start.setEnabled(false);


    }
}

