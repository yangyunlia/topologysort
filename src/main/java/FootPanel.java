import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class FootPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextArea t;
    FootPanel(MainFrame m) {
        mainFrame = m;
        setVisible(true);
        setBounds(0,mainFrame.getHeight()*7/10, mainFrame.getWidth(), mainFrame.getHeight()*3/10);
        t = new JTextArea(6, 80);
        t.setSize(mainFrame.getWidth(), mainFrame.getHeight()*3/10);
        JScrollPane jScrollPane = new JScrollPane(t);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(jScrollPane, BorderLayout.CENTER);
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
        t.setBounds(0,mainFrame.getHeight()*7/10, mainFrame.getWidth(), mainFrame.getHeight()*3/10);
        String content = "";
        for (int i = 0; i < mainFrame.graph.sortList.size(); i++) {
            Integer []a = mainFrame.graph.sortList.get(i);
            for(int j = 0; j < a.length; j++) {
                content += Integer.toString(a[j]) + " ";
            }
            if((i + 1) % 12 == 0) {
                content += "\n";
            } else {
                content += "   ";
            }
        }
        t.setText(content);
    }
}
