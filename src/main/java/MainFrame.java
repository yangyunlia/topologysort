import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Graph graph;
    MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();
        setTitle("拓扑排序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(screen.width/6, screen.height/6, screen.width*2/3, screen.height*2/3);
        add(new Head(this));
        add(new GraphPanel(this));
        add(new MatrixPanel(this));
        add(new FootPanel(this));
    }
}
