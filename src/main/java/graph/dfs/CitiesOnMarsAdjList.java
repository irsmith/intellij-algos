package graph.dfs;

/**
 * Created by irene on 6/22/16.
 */
public class CitiesOnMarsAdjList {


    public static void main(String[] args) {
        int N = 5;
        int [][] graph = new int[N][N];
        graph[0][1] = 1;
        graph[1][0] = 1;

        graph[1][2] = 1;
        graph[2][1] = 1;


        graph[3][1] = 1;
        graph[1][3] = 1;


        System.out.println(f(graph));

    }

    /*
     Given graph of cities and roads, return number of roads.
      Strategy: O(n-sqared).
      Start cur=0 and mark cur visited.
      Walk matrix. for m[i][j] if BOTH i and j not visited, and it has a road, increment road.
      optimization: only need to walk diagonal of matrix... but still N-squared
     */
    private static int f(int[][] graph) {
        int roads = 0;
        boolean marked[] = new boolean[graph.length];
        for (int v=0;v<graph.length;v++) {
            if (!marked[v]) {
                roads += dfs(graph, v);
            }

        }
        return roads;

    }

    private static int dfs(int[][] graph, int v) {
        int roads = 0;


        return roads;

    }
}
