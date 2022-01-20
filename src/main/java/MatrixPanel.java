import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MatrixPanel extends JPanel {
    private MainFrame mainFrame;
    MatrixPanel(MainFrame m) {
        mainFrame = m;
        setSize(mainFrame.getWidth()/2, mainFrame.getHeight()*6/10);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        setBounds(mainFrame.getWidth()/2, mainFrame.getHeight()/10, mainFrame.getWidth()/2, mainFrame.getHeight()*6/10);
        setVisible(true);
        if(mainFrame.graph == null) {
            return;
        }
        int n = mainFrame.graph.getvNum();
        setLayout(new GridLayout(n, n));
        int w=0,h=0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int v = mainFrame.graph.getMatrixValue(i, j);
                g2.drawString(Integer.toString(v), w, h);
                w += this.getWidth()/10;
            }
            h += this.getWidth()/10;
            w = 0;
        }
    }

}
