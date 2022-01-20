import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Graph {
    private int vNum;
    private int position[][];
    private int [][]matrix;
    private int []inDegree;
    private int []outDegree;
    private JFrame mainJFrame;
    private LinkedList<Integer> hList =  null;
    public ArrayList<Integer> sortList = new ArrayList<>();
    Graph(int vNum, JFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
        this.vNum = vNum;
        matrix = new int[vNum][vNum];
        inDegree = new int[vNum];
        outDegree = new int[vNum];
        position = new int[vNum][2];
        Random r = new Random();
        for(int i = 0;i < vNum; i++) {
            position[i][0] = r.nextInt(0, 100);
            position[i][1] = r.nextInt(0, 100);
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

    public boolean sortOneStep() {
        if(hList == null) {
            sortList.clear();
            hList = new LinkedList<>();
            for(int i = 0;i < vNum; i++) {
                if(inDegree[i] == 0) {
                    hList.add(i);
                }
            }
        }
        if(hList.isEmpty()) {
            hList = null;
            return false;
        }
        int a = hList.poll();
        sortList.add(a);
        for(int i = 0;i < vNum; i++) {
            if(matrix[a][i] == 1) {
                matrix[a][i] = 0;
                inDegree[i]--;
                if(inDegree[i] == 0) {
                    if (outDegree[i] == 0) {
                        sortList.add(i);
                    } else {
                        hList.add(i);
                        break;
                    }
                }
            }
        }
        mainJFrame.repaint();
        return true;
    }
}
