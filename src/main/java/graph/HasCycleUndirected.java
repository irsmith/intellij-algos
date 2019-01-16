package graph;

public class HasCycleUndirected {

    static int a2[][] = {
            {0,1,0,1},
            {1,0,1,0},
            {0,1,0,1},
            {1,0,1,0}
    };
    static int a[][] = {
            {0,1,0,1},
            {1,0,1,0},
            {0,1,0,0},
            {1,0,0,0}
    };
    static boolean visited[] = new boolean[a[0].length];
    static int V = a[0].length;


    // in undirected graph just hitting any cycle is sufficient.  However for a directed
    // graph hitting a cycle within same descent is necessary.
    public static void main(String[] args) {
        boolean hasCycle = false;
        for (int i=0; i< V; i++) {
            if (!visited[i]) {
                hasCycle = dfs(i);
            }
        }
        System.out.println(hasCycle ? "Ring Road" : "Tree Structure");
    }
    static boolean dfs(int v) {
        visited[v] = true;
        boolean childRevisited = false;
        for (int c = v+1; c <  V ; c++) {
            if (a[v][c] == 1) {
                if (visited[c]) {
                    childRevisited = true;
                    break;
                } else {
                    dfs(c);
                }
           }
        }
        return childRevisited;
    }
}
