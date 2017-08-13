package graph;

import jdk.nashorn.internal.objects.NativeRegExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * has cycle digraph
 */
public class DigraphHasCycle {

    static int V;
    static final int GREY = -1;
    static final int BLACK = 1;

    static List<List<Integer>> G;

    static int marked[];

    public static void main(String[] args) {
        G = new ArrayList<>();
        G.add(0, Arrays.asList(6));
        G.add(1, Arrays.asList(5));
        G.add(2, Arrays.asList(0));
        G.add(3, Arrays.asList(5));
        G.add(4, Arrays.asList(3,1));
        G.add(5, Arrays.asList(7));
        G.add(6, Arrays.asList(7,1));
        G.add(7, Arrays.asList());
        V=G.size();
        marked = new int[V];

        System.out.println(hascyl(G));
    }

    private static boolean hascyl(List<List<Integer>> G) {

        boolean result = false;
        for (int v=0; v < V; v++) {
            if (marked[v] != BLACK) {
                boolean r = dfs(v);
                result = result & r;
            }
        }
        return result;
    }

    static boolean dfs(int v){
        System.out.println("dfs:"+v);
        boolean result = false;
        marked[v]=GREY;

        for (int c: G.get(v) ) {

            if (marked[c] == GREY) {
                return false;
            }
            boolean r = dfs(c);
            result = result & r;
        }
        marked[v]=BLACK;
        return result;

    }

}
