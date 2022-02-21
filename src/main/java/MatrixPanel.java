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
        if (mainFrame.flag == 0) {
            g2.drawString("邻接矩阵", 30, 10);

        } else {
            g2.drawString("邻接链表", 30, 10);

        }
        if(mainFrame.graph == null) {
            return;
        }
        int n = mainFrame.graph.getvNum();
        int w=20,h=mainFrame.getHeight()/(n+10);
        g2.drawString("节点", w, h);
        h += this.getWidth()/(n+10);
        for(int i = 0; i < n; i++) {
            g2.drawString(Integer.toString(i), w, h);
            if (mainFrame.flag == 1) {
                g2.drawRect(w - 8,h -12 ,20,20);
                g2.drawLine(w + 20, h, w + 40, h);
                g2.drawLine(w + 40, h, w + 35, h - 5);
                g2.drawLine(w + 40, h, w + 35, h + 5);
            }
            w += 50;
            for(int j = 0; j < n; j++) {
                int v = mainFrame.graph.getMatrixValue(i, j);
                if (mainFrame.flag == 1) {
                    if( v != 0) {
                        g2.drawRect(w - 8,h -12 ,20,20);
                        g2.drawString(Integer.toString(j), w, h);
                        w += this.getWidth()/(n+10);
                    }
                } else  {
                    g2.drawString(Integer.toString(v), w, h);
                    w += this.getWidth()/(n+10);
                }
            }
            h += 50;
            w = 20;
        }
    }

}
