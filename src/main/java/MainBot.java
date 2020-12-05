import javax.swing.*;
import java.awt.*;

public class MainBot extends JFrame {
    private JPanel panel;

    public static void main(String[] args) {
        new MainBot();

    }

    private MainBot() {
        initPanel();
        initFrame();

    }

    private void initPanel() {
        Dimension scrResol = Toolkit.getDefaultToolkit().getScreenSize();
        int h = scrResol.height;
        int w = scrResol.width;
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(w / 2, h / 2));
        add(panel);
    }

    private void initFrame() {
        pack();
        setTitle("Steam Bot");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

    }
}
