package graph;

import java.util.*;

public class PathToFarSide {
    static List<Integer> nearCities = new ArrayList<>(Arrays.asList(1,2,3));
    static int adj[][] = new int[][] {
            {1,2},
            {2,1},
            {2,3},
            {3,4}
    };

    public static void main(String[] args) {
        boolean found = false;
        for (int i = 0;i< adj.length; i++) {
            boolean isSourceFar = !(nearCities.contains(adj[i]));
            if (isSourceFar) {
                for (int child : adj[i]) {
                    if (nearCities.contains(child)) {
                        found = true;
                        break;
                    }
                }
            }
        }
        System.out.println(found ? "YES" : "NO");
    }
}


//    static List<Integer> case2near = new ArrayList<>(Arrays.asList(1));
//    static int case2[][] = new int[][] {
//            {2,3}
//    };