import menu.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MainBot extends JFrame {
    private JPanel panel;
    private JButton butLogIn;
    private JButton butLogOut;
    private JButton butStart;
    private JButton butStop;
    private JButton butSettings;


    Monitor<Integer> monitor = new Monitor<>();

    private Font guns = getMyFont();
    private ButSettings bset=new ButSettings(guns);

    public static void main(String[] args) {
        new MainBot();

    }

    private MainBot() {
        initPanel();
        initFrame();
        monitor.setValue(0);
    }

    private JButton getButSettings() {
        butSettings = new JButton("Settings");
        butSettings.setFont(guns.deriveFont(15f));
        butSettings.setForeground(Color.BLACK);
        butSettings.setBackground(Color.WHITE);
        butSettings.setPreferredSize(new Dimension(100, 50));
        butSettings.addActionListener(bset);
        butSettings.setFocusPainted(false);
        return butSettings;
    }

    private JButton getButLogIn() {
        butLogIn = new JButton("Sign in");
        butLogIn.setFont(guns.deriveFont(45f));
        butLogIn.setForeground(Color.BLACK);
        butLogIn.setBackground(Color.GREEN);
        butLogIn.setPreferredSize(new Dimension(185, 65));
        butLogIn.addActionListener(new BLogged(guns));
        butLogIn.setFocusPainted(false);
        return butLogIn;
    }

    private JButton getButStart() {
        butStart = new JButton("Start");
        butStart.setFont(guns.deriveFont(45f));
        butStart.setForeground(Color.BLACK);
        butStart.setBackground(Color.GREEN);
        butStart.setPreferredSize(new Dimension(185, 65));
        butStart.addActionListener(new ButStart(guns, monitor));
        butStart.setFocusPainted(false);
        return butStart;
    }

    private JButton getButStop() {
        butStop = new JButton("Stop");
        butStop.setFont(guns.deriveFont(45f));
        butStop.setForeground(Color.BLACK);
        butStop.setBackground(Color.RED);
        butStop.setPreferredSize(new Dimension(185, 65));
        butStop.addActionListener(new ButStop(guns, monitor));
        butStop.setFocusPainted(false);
        return butStop;
    }


    private void initPanel() {
        Dimension scrResol = Toolkit.getDefaultToolkit().getScreenSize();
        int h = scrResol.height;
        int w = scrResol.width;
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(w / 3, h / 3));
        panel.setBackground(Color.BLACK);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NORTH;
        constraints.weightx = 0.5;
        constraints.gridy = 0;
        panel.add(getButSettings());

        panel.add(getButStart());
        panel.add(getButStop());
        add(panel);
    }

    private void initFrame() {
        pack();
        setTitle("Steam Bot");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setIconImage(getIcon());


    }

    private Font getMyFont() {
        String po = "src/main/resources/font/Mostwasted.ttf";
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(po));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);
        return customFont;
    }

    private Image getIcon() {
        String way = "icon/icon.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(way));
        return icon.getImage();

    }
}
