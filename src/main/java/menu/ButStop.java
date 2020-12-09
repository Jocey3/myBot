package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButStop implements ActionListener {
    Font font;
    Monitor<Integer> monitor;

    public ButStop(Font font, Monitor<Integer> monitor) {
        this.font = font;
        this.monitor = monitor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        monitor.setValue(0);
    }
}
