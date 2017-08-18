package TODO;

public class Visitor {
    static int N = 4;
    static int g[][] = {
            {0,1,0,0},
            {1,0,1,0},
            {0,1,0,1},
            {0,0,1,0},
    };
    static boolean [] marked = new boolean[N];

    public static void main(String[] args) {
        helper(g);
    }

    private static void helper(int[][] g) {
        for (int i =0; i<g.length; i++) {
            f(g, i, i);
        }
    }

    private static void f(int[][] g, int parent, int v) {

        marked[v] = true;
        // descend to all v's children
        int children[] = g[v];
        for (int i = 0; i < N; i++) {
            int child = children[i];
            if ((child == 1) && (i != parent) && !marked[child]) {
                f(g, v, i);
            }
        }
    }
//        System.out.println("visit:"+v+" parent:"+parent);

}
