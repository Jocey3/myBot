package menu;

import menu.settings.SettingsWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButSettings implements ActionListener {
    SettingsWindow settingsWindow;
    Font font;
    public ButSettings(Font font){
        this.font=font;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        settingsWindow=new SettingsWindow(font);
    }
}
