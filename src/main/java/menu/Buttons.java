package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements ActionListener {
    Font font;

    public Buttons(Font font) {
        this.font = font;
    }

    public void actionPerformed(ActionEvent pressed) {
        int tr = 0;
        String text = (String) pressed.getActionCommand();
        JButton start;
        JButton stop;
        if (text.equals("Start")) {
            start = (JButton) pressed.getSource();
            start.setFont(font.deriveFont(20f));
            start.setForeground(Color.BLACK);
            start.setBackground(Color.DARK_GRAY);
            start.setEnabled(false);
            tr = 1;
            while (tr == 1) {
                for (; ; ) {
                    System.out.println("processed...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else if (text.equals("Stop")) {
            stop = (JButton) pressed.getSource();
            stop.setFont(font.deriveFont(20f));
            stop.setForeground(Color.BLACK);
            stop.setBackground(Color.DARK_GRAY);
            tr = 0;
        }


    }
}

