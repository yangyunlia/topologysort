import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class FootPanel extends JPanel {
    private MainFrame mainFrame;
    FootPanel(MainFrame m) {
        mainFrame = m;
        setVisible(true);
        setBounds(0,mainFrame.getHeight()*7/10, mainFrame.getWidth(), mainFrame.getHeight()*3/10);
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        setVisible(true);
        setBounds(0,mainFrame.getHeight()*7/10, mainFrame.getWidth(), mainFrame.getHeight()*3/10);
        if(mainFrame.graph == null) {
            return;
        }
        Object [][]data = new Object[1][mainFrame.graph.getvNum()];
        Arrays.fill(data[0], -1);
        int w = 0;
        int h = this.getHeight()/2;
        for (int i = 0; i < mainFrame.graph.sortList.size(); i++) {
            g2.drawString(Integer.toString(mainFrame.graph.sortList.get(i)), w, h);
            w += 20;
        }
    }
}
