package graph;

import java.util.Stack;

public class OneCity {

    static int adj2[][] = new int[][] {
            {1},
            {0,4},
            {3},
            {2,4},
            {1,3}};
    static int adj[][] = new int[][] {
            {1},
            {0},
            {},
            {4},
            {3}};
    static int V = 5; // 5 vertices

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        int cnt = 0;
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (int c:adj[v]) {
                if (!visited[c]) {
                    visited[c]=true;
                    stack.push(c);
                    cnt++;
                }
            }
        }
        System.out.println(cnt == V ? "YES" : "NO");
    }
}
