import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

public class GraphPanel extends JPanel {
    private MainFrame mainFrame;
    GraphPanel(MainFrame m) {
        mainFrame = m;
        setSize(mainFrame.getWidth()/2, mainFrame.getHeight()*6/10);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        setBounds(0, mainFrame.getHeight()/10, mainFrame.getWidth()/2, mainFrame.getHeight()*6/10);
        Graphics2D g2 = (Graphics2D) g;
        if(mainFrame.graph == null) {
            return;
        }
        int n = mainFrame.graph.getvNum();
        for (int i = 0; i < n; i++) {
            int []p = mainFrame.graph.getPosition(i);
            double x = p[0]/100.0*(this.getWidth() - 100);
            double y =  p[1]/100.0*(this.getHeight() -100);
            Ellipse2D e = new Ellipse2D.Double(x, y, 20,20);
            int c = mainFrame.graph.result.indexOf(i);
            if(c != -1) {
                g2.drawString(Integer.toString(c), (float) x, (float)y + 3);
                g2.setColor(Color.red);
                g2.draw(e);
            } else {
                g2.setColor(Color.black);
                g2.draw(e);
            }
            g2.setColor(Color.black);
            g2.drawString(Integer.toString(i), (float) x+8, (float)y+15);
        }

        for(int i = 0;i < n; i++) {
            int []pi = mainFrame.graph.getPosition(i);
            double xi = pi[0]/100.0*(this.getWidth() - 50)+14;
            double yi =  pi[1]/100.0*(this.getHeight() -50)+14;
            for (int j = 0;j < n; j++) {
                if(mainFrame.graph.getMatrixValue(i, j) != 0) {
                    int []pj = mainFrame.graph.getPosition(j);
                    double xj = pj[0]/100.0*(this.getWidth() - 50)+14;
                    double yj =  pj[1]/100.0*(this.getHeight() -50)+14;
                    Line2D line2D = new Line2D.Double(xi, yi, xj, yj);
                    g2.draw(line2D);
                    GeneralPath l = new GeneralPath();
                    double arcTan = Math.atan2((xj-xi), (yj-yi));
                    double midX = (xj + xi)/2;
                    double midY = (yj + yi)/2;
                    double xe1 = midX - 10*Math.sin(arcTan + Math.PI/6);
                    double ye1 = midY - 10*Math.cos(arcTan + Math.PI/6);
                    double xe2 = midX - 10*Math.sin(arcTan - Math.PI/6);
                    double ye2 = midY - 10*Math.cos(arcTan - Math.PI/6);
                    l.moveTo(midX, midY);
                    l.lineTo(xe1, ye1);
                    l.moveTo(midX, midY);
                    l.lineTo(xe2, ye2);
                    g2.draw(l);
                }
            }
        }
    }
}
