package menu;

import selenium.SeleniumManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButSignIn implements ActionListener {
    Font font;
    SeleniumManage seleniumManage;

    public ButSignIn(Font font) {
        this.font = font;
    }

    public void actionPerformed(ActionEvent pressed) {
        JButton start = (JButton) pressed.getSource();
        start.setFont(font.deriveFont(20f));
        start.setForeground(Color.BLACK);
        start.setBackground(Color.DARK_GRAY);
        start.setEnabled(false);
        seleniumManage=new SeleniumManage();

    }
}

