import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public interface Graph {
    public int getvNum();

    public int getMatrixValue(int i, int j) ;

    public int[] getPosition(int i) ;

    public void addPath(int a, int b) ;

    public void deletePath(int a, int b);

    public void topologySort();

    public void sort(LinkedList<Integer> nodes);

    public List<Integer> getResult();

    public ArrayList<Integer[]> getSortList();
}
