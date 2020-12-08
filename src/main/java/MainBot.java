import menu.Buttons;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainBot extends JFrame {
    private JPanel panel;
    private JButton butStart;
    private JButton butStop;
    private Font guns = getMyFont();
    private Buttons buttons = new Buttons(guns);

    public static void main(String[] args) {
        new MainBot();

    }

    private MainBot() {
        initPanel();
        initFrame();

    }

    private JButton getButStart() {
        butStart = new JButton("Start");
        butStart.setFont(guns.deriveFont(45f));
        butStart.setForeground(Color.BLACK);
        butStart.setBackground(Color.GREEN);
        butStart.setPreferredSize(new Dimension(185, 65));
        butStart.addActionListener(buttons);
        butStart.setFocusPainted(false);
        return butStart;
    }

    private JButton getButStop() {
        butStop = new JButton("Stop");
        butStop.setFont(guns.deriveFont(45f));
        butStop.setForeground(Color.BLACK);
        butStop.setBackground(Color.RED);
        butStop.setPreferredSize(new Dimension(185, 65));
        butStop.addActionListener(buttons);
        butStop.setFocusPainted(false);
        return butStop;
    }

    private void initPanel() {
        Dimension scrResol = Toolkit.getDefaultToolkit().getScreenSize();
        int h = scrResol.height;
        int w = scrResol.width;
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(w / 4, h / 4));
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
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
