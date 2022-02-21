import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class GraphList implements Graph{
    private int vNum;
    private int position[][];
    private LinkedList<Integer>[] list;
    private int []inDegree;
    private int []outDegree;
    private JFrame mainJFrame;
    LinkedList<Integer> result = new LinkedList<>();
    public ArrayList<Integer[]> sortList = new ArrayList<>();
    GraphList(int vNum, JFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
        this.vNum = vNum;
        list = new LinkedList[vNum];
        inDegree = new int[vNum];
        outDegree = new int[vNum];
        position = new int[vNum][2];
        Random r = new Random();
        for(int i = 0;i < vNum; i++) {
            position[i][0] = r.nextInt(100);
            position[i][1] = r.nextInt(100);
            inDegree[i] = 0;
            outDegree[i] = 0;
            list[i] = new LinkedList<>();
            for(int j = 0;j < vNum; j++) {
                list[i].add(0);
            }
        }

    }

    public int getvNum() {
        return vNum;
    }

    public int getMatrixValue(int i, int j) {
        return list[i].get(j);
    }

    public int[] getPosition(int i) {
        return position[i];
    }

    public void addPath(int a, int b) {
        if(list[a].get(b) == 0) {
            list[a].set(b, 1);
            inDegree[b]++;
            outDegree[a]++;
        }
        mainJFrame.repaint();
    }

    public void deletePath(int a, int b) {
        if(list[a].get(b) == 1) {
            list[a].set(b, 0);
            inDegree[b]--;
        }
        mainJFrame.repaint();
    }

    public void topologySort() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < vNum; i++) {
            if(inDegree[i] == 0) {
                list.add(i);
            }
        }
        sort(list);
    }

    public void sort(LinkedList<Integer> nodes) {
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
                Thread.sleep(1000);
            }catch (Exception e) {

            }
            LinkedList<Integer> l = new LinkedList<>();
            for (int j = 0;j < nodes.size(); j ++) {
                if(j != i) {
                    l.add(nodes.get(j));
                }
            }
            for(int j = 0;j < vNum; j++) {
                if(list[s].get(j) != 0) {
                    inDegree[j]--;
                    if(inDegree[j] == 0) {
                        l.add(j);
                    }
                }
            }
            sort(l);
            for(int j = 0;j < vNum; j++) {
                if(list[s].get(j) != 0) {
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
}
