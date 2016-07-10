package graph.dfs;

/**
 * Created by irene on 6/22/16.
 */
public class CitiesOnMarsMatrix {

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
      Walk matrix. for m[i][j], and it has a road, increment road.
      optimization: only need to walk diagonal of matrix... but still N-squared
     */
    private static int f(int[][] graph) {
        int roads = 0;
        for (int v=0;v<graph.length;v++) {
                for (int w = 0; w <=v ; w++) {
                    System.out.format("v:%d,w:%d ",v,w);
                    if (graph[v][w] == 1) roads++;
            }
        }
        return roads;
    }

}
