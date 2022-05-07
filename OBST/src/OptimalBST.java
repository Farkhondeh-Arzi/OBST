import java.util.ArrayList;

public class OptimalBST {

    private int n;
    private ArrayList<Double> p;
    private ArrayList<Double> q;

    double[][] e;
    double[][] w;
    int[][] root;

    OptimalBST(int n, ArrayList<Double> p, ArrayList<Double> q) {
        this.n = n;
        this.p = p;
        this.q = q;

        e = new double[n + 1][n];
        w = new double[n + 1][n];
        root = new int[n][n];
    }

    public void findBST() {

        for (int i = 1; i < n + 1; i++) {
            e[i][i - 1] = q.get(i - 1);
            w[i][i - 1] = q.get(i - 1);
        }

        for (int l = 1; l < n; l++) {

            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;

                e[i][j] = Integer.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p.get(j) + q.get(j);

                for (int r = i; r <= j; r++) {
                    double t = e[i][r - 1] + e[r + 1][j] + w[i][j];

                    if (t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }

                System.out.println("w: " + i + "," + j + " " + w[i][j] + " e: " + e[i][j] + " root: " + root[i][j]);
            }
        }
    }

    public void constructOptimalBST(int i, int j, int last) {
        if (i == j) return;

        if (last == 0) System.out.println("k" + root[i][j] + " is the root");

        else if (j < last) System.out.println("k" + root[i][j] + " is the left child of k" + last);

        else System.out.println("k" + root[i][j] + " is the right child of k" + last);

        constructOptimalBST(i, root[i][j] - 1, root[i][j]);
        constructOptimalBST(root[i][j] + 1, j, root[i][j]);
    }

}
