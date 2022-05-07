import java.util.ArrayList;

public class Main {

    public static void main(String... args) {

        ArrayList<Double> p = new ArrayList<>();
        p.add(0.0);
        p.add(0.04);
        p.add(0.06);
        p.add(0.08);
        p.add(0.02);
        p.add(0.1);
        p.add(0.012);
        p.add(0.14);

        ArrayList<Double> q = new ArrayList<>();
        q.add(0.06);
        q.add(0.06);
        q.add(0.06);
        q.add(0.06);
        q.add(0.05);
        q.add(0.05);
        q.add(0.05);
        q.add(0.05);

        OptimalBST oBST = new OptimalBST(8, p, q);

        oBST.findBST();

        System.out.println("----------------------------------------------------------------");

        oBST.constructOptimalBST(1, 7, 0);
    }
}
