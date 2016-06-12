package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.Point;
import java.util.Map;

/**
 * from Eugene spring 2015 .
 */
public class MaxPathSum {
    public static void main(String[] args) {

        Integer a[][] = new Integer[4][4];
        a[0][0] = 3;
        a[0][1] = 1;
        a[0][2] = 6;
        a[0][3] = 3;

        a[1][0] = 2;
        a[1][1] = 4;
        a[1][2] = 9;

        a[2][0] = 6;
        a[2][1] = 2;

        a[3][0] = 1;

        System.out.println(f(a));

    }

    private static List<Integer> f(Integer[][] a) {

        List<Integer> rv = new ArrayList<>();
        Map<Integer,Integer> pathFrom = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int r = 0;r<a.length;r++) {
            for (int c=0;c<a[r].length;c++) {
                Integer cur=a[r][c];
                if (cur==null) continue;
                if (r-1<0 && c-1<0) {
                    continue;  //is root
                } else if (r-1 < 0) {
                    // we're on top row, increment west
                    cur += a[r][c-1];
                    pathFrom.put(cur, a[r][c-1]);

                } else if (c-1<0) {
                    // we're on left col, increment north
                    cur += a[r-1][c];
                    pathFrom.put(cur, a[r-1][c]);

                } else { // find greater of n and w

                    if (a[r-1][c] > a[r][c-1] ) {
                        cur += a[r-1][c];
                        pathFrom.put(cur, a[r-1][c]);
                    } else {
                        cur += a[r][c-1];
                        pathFrom.put(cur, a[r][c-1]);
                    }


                }
                // if is leaf store max so far and cont.
                if (c+1==a[r].length || a[r][c+1]==null) {
                    if (cur > max) {
                        max=cur;
                    }
                }
            }
            Integer prev = pathFrom.get(max);
            while (prev != null) {
                rv.add(prev);
                prev=pathFrom.get(prev);
            }

        }
        System.out.println(max);


        return rv;
    }
}
