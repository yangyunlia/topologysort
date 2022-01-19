import javax.swing.*;
import java.awt.*;

public class Head extends JPanel {
    Head(int w,int h) {
        Font font = new Font("楷书",Font.BOLD,20);
        setFont(font);
        setVisible(true);
        setSize(w, h);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Label label = new Label("输入节点数目");
        label.setSize(20, h);
        TextField vNum = new TextField();
        JPanel in = new JPanel();
        in.setLayout(new BoxLayout(in, BoxLayout.X_AXIS));
        in.add(label);
        in.add(vNum);
        Button generate = new Button("随机生成拓扑图");
        Button sort = new Button("执行拓扑排序");
        add(in);
        add(generate);
        add(sort);
    }
}
