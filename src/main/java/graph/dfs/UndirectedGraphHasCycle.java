package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * has cycle digraph
 */
public class UndirectedGraphHasCycle {

    static int V;
    static boolean hasCycle;

    static List<List<Integer>> G;

    static boolean marked[];

    public static void main(String[] args) {
        G = new ArrayList<>();
        // make the data
        gCycle();
        //g_noCycle();

        V=G.size();
        marked = new boolean[V];

        hascyl(G);

        System.out.println(hasCycle);
    }


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

    // Outer loop is needed because graph may not all be connected
    private static void hascyl(List<List<Integer>> G) {

        for (int s=0; s < V; s++) {
            if (!marked[s]) {
                dfs(s, s);  // basically we never descend into dfs if marked.
            }
        }
        return;
    }

    static void dfs(int v, int u){
        System.out.printf("dfs on %d with immediate parent %d %n", v, u);

        marked[v]=true; //visit before descending to children

        for (int w: G.get(v) ) {

            if (!marked[w]) {
                dfs(w, v);
            }  else {
                if (w != u)  // ignore the "parellel" edge
                    hasCycle = true;
            }
        }
        return ;

    }

}
