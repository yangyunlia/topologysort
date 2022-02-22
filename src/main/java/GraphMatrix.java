import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class GraphMatrix implements Graph{
    private int vNum;
    private int position[][];
    private int [][]matrix;
    private int []inDegree;
    private int []outDegree;
    private JFrame mainJFrame;
    private int runMode;
    LinkedList<Integer> result = new LinkedList<>();
    public ArrayList<Integer[]> sortList = new ArrayList<>();
    GraphMatrix(int vNum, JFrame mainJFrame) {
        runMode = 1;
        this.mainJFrame = mainJFrame;
        this.vNum = vNum;
        matrix = new int[vNum][vNum];
        inDegree = new int[vNum];
        outDegree = new int[vNum];
        position = new int[vNum][2];
        Random r = new Random();
        for(int i = 0;i < vNum; i++) {
            position[i][0] = r.nextInt(100);
            position[i][1] = r.nextInt(100);
            inDegree[i] = 0;
            outDegree[i] = 0;
            for(int j = 0;j < vNum; j++) {
                matrix[i][j] = 0;
            }
        }

    }

    public int getvNum() {
        return vNum;
    }

    public int getMatrixValue(int i, int j) {
        return matrix[i][j];
    }

    public int[] getPosition(int i) {
        return position[i];
    }

    public void addPath(int a, int b) {
        if(matrix[a][b] == 0) {
            matrix[a][b] = 1;
            inDegree[b]++;
            outDegree[a]++;
        }
        mainJFrame.repaint();
    }

    public void deletePath(int a, int b) {
        if(matrix[a][b] == 1) {
            matrix[a][b] = 0;
            inDegree[b]--;
        }
        mainJFrame.repaint();
    }

    public boolean topologySort() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < vNum; i++) {
            if(inDegree[i] == 0) {
                list.add(i);
            }
        }
        sort(list);
        JFrame msg = new JFrame();
        msg.setBounds(300,300, 100, 100);
        msg.add(new JLabel("完成"));
        msg.setVisible(true);
        sortList.clear();
        return true;
    }

    public synchronized void sort(LinkedList<Integer> nodes) {
        if(result.size() == vNum) {
            Integer[] r = new Integer[result.size()];
            for (int i = 0; i < result.size(); i++) {
                r[i] = result.get(i);
            }
            this.sortList.add(r);
            mainJFrame.repaint();
            return;
        }
        for (int i = 0; i < nodes.size(); i++) {
            int s = nodes.get(i);
            result.add(s);
            mainJFrame.repaint();
            try {
                if(runMode == 1) {
                    wait();
                } else {
                    Thread.sleep(1000);
                }
            }catch (Exception e) {

            }
            LinkedList<Integer> l = new LinkedList<>();
            for (int j = 0;j < nodes.size(); j ++) {
                if(j != i) {
                    l.add(nodes.get(j));
                }
            }
            for(int j = 0;j < vNum; j++) {
                if(matrix[s][j] != 0) {
                    inDegree[j]--;
                    if(inDegree[j] == 0) {
                        l.add(j);
                    }
                }
            }
            sort(l);
            for(int j = 0;j < vNum; j++) {
                if(matrix[s][j] != 0) {
                    inDegree[j]++;
                }
            }
            result.removeLast();
        }

    }

    public ArrayList<Integer[]> getSortList() {
        return sortList;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setRunMode(int m) {
        runMode = m;
    }

    public int getRunMode() {
        return runMode;
    }

    public synchronized void oneStep() {
        notify();
    }
}

