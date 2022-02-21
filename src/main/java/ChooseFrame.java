import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseFrame extends JFrame {
    ChooseFrame() {
        ChooseFrame that = this;
        setBounds(300, 300, 300, 300);
        JPanel p = new JPanel();
        add(p);
        JButton matrix = new JButton("邻接矩阵");
        JButton list = new JButton("邻接链表");
        p.add(matrix);
        p.add(list);
        matrix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame(0).setVisible(true);
                that.setVisible(false);
            }
        });

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame(1).setVisible(true);
                that.setVisible(false);
            }
        });
        setVisible(true);
    }
}
