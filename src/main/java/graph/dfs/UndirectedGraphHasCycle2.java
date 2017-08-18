package graph.dfs;

import java.util.*;

/**
 * has cycle digraph
 */
public class UndirectedGraphHasCycle2 {

    static int V;

    static List<List<Integer>> G;


    static Set<Integer> marked = new HashSet<>();

    public static void main(String[] args) {

        G = new ArrayList<>();

        V = G.size();
        // make the data
        //gCycle();
        g_noCycle();

        System.out.println(hasCycle(G));
    }

    private static boolean hasCycle(List<List<Integer>> g) {

        boolean rv = false;
        for (int v=0;v<G.size();v++) {
            if (!marked.contains(v)) {
                if (dfs(v, v) == true) return true;
            }
        }


        return rv;

    }

    static boolean dfs(int v, int p) {

        marked.add(v);
        for (int c : G.get(v)) {
            if (marked.contains(c)) return true;
            return dfs(c, v);
        }

        return false;
    }




    static boolean dfs_DIRECTED(int v) {

        marked.add(v);
        for (int c : G.get(v)) {
            if (marked.contains(c)) return true;
            return dfs_DIRECTED(c);
        }

        return false;
    }



    /*
// FOR Undirected, matrix is semetric because there are 2 edges ,eg 0 to 1
  and 1 to 0.  Thus if you traverse from 0 to 1, and curr=1 there is still a
  "child" of 1 which is it's parent!  Thus you want to ignore the parent.
//    0 1 1
//    1 0 0
//    1 0 0

*/
    private static void g_noCycle() {
        G.add(0, Arrays.asList(1,2));
        G.add(1, Arrays.asList(0));
        G.add(2, Arrays.asList(0));
    }

    private static void gCycle() {
        G.add(0, Arrays.asList(1,2));
        G.add(1, Arrays.asList(0,2));
        G.add(2, Arrays.asList(0,1));
    }
}