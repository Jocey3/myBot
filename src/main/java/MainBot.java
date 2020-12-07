import menu.ButtonStart;
import menu.ButtonStop;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainBot extends JFrame {
    private JPanel panel;
    private JButton butStart;
    private JPanel butPanel;
    private JButton butStop;

    public static void main(String[] args) {
        new MainBot();

    }

    private MainBot() {
        initPanel();
        initFrame();

    }

    private JButton getButStart() {
        butStart = new JButton("Start");
        butStart.addActionListener(new ButtonStart());
        butStart.setBackground(Color.BLACK);
        butStart.setPreferredSize(new Dimension(150, 50));
        return butStart;
    }

    private JButton getButStop() {

        Font guns = getMyFont();
        butStop = new JButton("Stop");
        butStop.setFont(guns);
        butStop.addActionListener(new ButtonStop());
        butStop.setBackground(Color.RED);
        butStop.setPreferredSize(new Dimension(150, 50));
        return butStop;
    }

    private void initPanel() {
        Dimension scrResol = Toolkit.getDefaultToolkit().getScreenSize();
        int h = scrResol.height;
        int w = scrResol.width;
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(w / 2, h / 4));
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(getButStart());
        panel.add(getButStop());
        add(panel);
    }

    private void initFrame() {
        pack();
        setTitle("Steam Bot");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getIcon());


    }

    private Font getMyFont() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(getClass().getResource("font/Mostwasted.ttf").getFile());
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, file));

        } catch (FontFormatException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font myF = null;
        try {
            myF = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(12f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myF;
    }

    private Image getIcon() {
        String way = "icon/icon.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(way));
        return icon.getImage();

    }
}
