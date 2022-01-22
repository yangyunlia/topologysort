import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SortTask implements Runnable {
    boolean flag;
    MainFrame mainFrame;
    @Override
    public void run() {
        if (mainFrame.graph == null) {
            return;
        }
        mainFrame.graph.topologySort();
        flag = false;
    }
}

public class Head extends JPanel {
    SortTask sortTask = new SortTask();
    private MainFrame mainFrame;
    private boolean flag = false;
    Head(MainFrame m) {
        mainFrame = m;
        sortTask.mainFrame = m;
        int w = mainFrame.getWidth();
        int h = mainFrame.getHeight()/15;
        Font font = new Font("楷书",Font.BOLD,20);
        setFont(font);
        setVisible(true);
        setSize(w, h);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Label label = new Label("输入节点数目");
        label.setSize(20, h);
        final TextField vNum = new TextField();
        vNum.setFont(font);
        JPanel in = new JPanel();
        in.setLayout(new BoxLayout(in, BoxLayout.X_AXIS));
        in.add(label);
        in.add(vNum);
        Button generate = new Button("随机生成拓扑图");
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vn;
                try {
                    vn = Integer.parseInt(vNum.getText());
                }catch (Exception E) {
                    System.out.println("输入节点数量");
                    return;
                }
                mainFrame.graph = new Graph(vn, mainFrame);
                mainFrame.repaint();
            }
        });
        Button sort = new Button("执行拓扑排序");
        final Head that = this;
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sortTask.flag) {
                    return;
                }
                sortTask.flag = true;
                Thread t = new Thread(sortTask);
                t.start();

            }
        });
        add(in);
        add(generate);
        add(sort);
        JLabel path = new JLabel("输入边");
        TextField start = new TextField();
        TextField end = new TextField();
        Button addPath = new Button("添加");
        addPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a,b;
                try {
                    a = Integer.parseInt(start.getText());
                    b = Integer.parseInt(end.getText());
                }catch (Exception E) {
                    System.out.println("输入边");
                    return;
                }
                if(a == b || a >= mainFrame.graph.getvNum() || b >= mainFrame.graph.getvNum()) {
                    return;
                }
                mainFrame.graph.addPath(a, b);
            }
        });
        add(path);
        add(start);
        add(end);
        add(addPath);
    }
}
