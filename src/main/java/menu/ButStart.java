package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButStart implements ActionListener {
    Font font;
    Monitor<Integer> monitor;
    PotokStart potokStart;

    public ButStart(Font font, Monitor<Integer> monitor) {
        this.font = font;
        this.monitor = monitor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        monitor.setValue(1);
        JButton button= (JButton) actionEvent.getSource();
        button.setEnabled(false);
        potokStart = new PotokStart(monitor);
        button.setEnabled(true);
    }
}
