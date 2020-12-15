package menu.settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    JPanel panel;
    JButton butOK;
    Font font;
    JTextField username = new JTextField("username", 30);
    JTextField pass = new JTextField("pass", 30);
    JTextField link = new JTextField("skin link", 30);
    JSpinner stickersSum = new JSpinner(new SpinnerNumberModel(5, 0, 1000, 5));
    JComboBox comboBox = getComboBox();
    Integer period = 1;

    public SettingsWindow(Font font) {
        this.font = font;
        initPanel();
        initFrame();
    }

    private JComboBox getComboBox() {
        Integer arg[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        comboBox = new JComboBox(arg);
        comboBox.setFont(font);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JComboBox comboBox = (JComboBox) actionEvent.getSource();
                period = comboBox.getSelectedIndex() + 1;
            }
        });
        return comboBox;
    }

    private void initPanel() {
        Dimension scrResol = Toolkit.getDefaultToolkit().getScreenSize();
        int h = scrResol.height;
        int w = scrResol.width;
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(w / 4, h / 5));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("Username:"));
        panel.add(username);
        panel.add(new JLabel("Password:"));
        panel.add(pass);
        panel.add(new JLabel("Skin link:"));
        panel.add(link);
        panel.add(new JLabel("Minimum amount of stickers:"));
        panel.add(stickersSum);
        panel.add(new JLabel("Delay in seconds:"));
        panel.add(comboBox);
        panel.add(getButOK());
        add(panel);

    }

    private void initFrame() {
        pack();
        setTitle("Settings");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


    }

    ManageSettingsFile manage;

    private void saveSettings() {
        manage = new ManageSettingsFile();
        manage.writeInSettings(new SettingsData(username.getText(), pass.getText(), link.getText(), period, (Integer) stickersSum.getValue()));
    }

    private JButton getButOK() {
        butOK = new JButton("Ok");
        butOK.setFont(font.deriveFont(35f));
        butOK.setForeground(Color.BLACK);
        butOK.setBackground(Color.WHITE);
        butOK.setPreferredSize(new Dimension(80, 40));
        butOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton button = (JButton) actionEvent.getSource();
                button.setEnabled(false);
                saveSettings();
            }
        });
        butOK.setFocusPainted(false);
        return butOK;
    }


}
