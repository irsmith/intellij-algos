package TODO;

public class Ring {
    static int N = 4;
    static int g[][] = {
            {0,1,0,0},
            {1,0,1,0},
            {0,1,0,1},
            {0,0,1,0},
    };
    static int g2[][] = {
            {0,1,0,1},
            {1,0,1,0},
            {0,1,0,1},
            {1,0,1,0},
    };
    static boolean[] marked = new boolean[4];

    public static void main(String[] args) {
        System.out.println(helper(g));
    }


    private static boolean helper(int[][] g) {
        boolean rv = false;
        for (int i =0; i<g.length; i++) {
            rv = rv && f(g, i, i);
        }
        return rv;
    }

    private static boolean f(int[][] g, int parent, int v) {

        // visit the current node v.  If it's marked we have a cycle.
        if (marked[v] == true)  return true;
        boolean rv = false;
        // descend to all v's children
        for (int i=0;i<N ; i++) {
            //int chile = g[]
        }
        return rv;
    }


}
