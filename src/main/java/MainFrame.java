import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();
        setTitle("拓扑排序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(screen.width/4, screen.height/4, screen.width/2, screen.height/2);
        add(new Head(this.getWidth(), this.getHeight()/10), BorderLayout.NORTH);
        add(new GraphPanel(), BorderLayout.WEST);
        add(new MatrixPanel(), BorderLayout.EAST);
        add(new FootPanel(), BorderLayout.SOUTH);
    }
}
