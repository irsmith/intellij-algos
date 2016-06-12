package dp;

import java.util.*;
import java.util.List;

import array.Shuffle;

/**
 * Created by irene on 6/11/16.
 */
public class Knapsac2 {

    public static void main(String[] args) {
        int S = 9;
        int[] profit = {0,3,7,2,9};// TRICK! pad out 0th index
        int[] weight ={0,2,3,4,5};// new int[N+1];
        //Shuffle.shuffleInPlace(weight);
        int N = profit.length-1;
        boolean keep[][] = new boolean[N+1][S+1];

        int dp[][] = new int[N+1][S+1];
        for (int k=1;k<=N;k++) {
            dp[0][k] =0;
        }

        for (int i=1;i<=N;i++) {
            for (int cap=1;cap <= S;cap++) {

                if (weight[i] > cap) {
                    //cannot accept. Optimal solution is above
                    dp[i][cap] = dp[i-1][cap];
                    continue;
                }

                int dontAccept = dp[i-1][cap];
                int accept = profit[i] + dp[i-1][cap - weight[i]];

                dp[i][cap] = Math.max(dontAccept, accept);
                if (accept > dontAccept) {
                    keep[i][cap] = true;
                }


            }

        }
        System.out.println("keep");
        for (int i=0;i<keep.length;i++) {
            for (int cap = 0; cap < keep[0].length; cap++) {
                System.out.print(" "+keep[i][cap]);
            }
            System.out.println();
        }
        List<Integer> res = new ArrayList<>();
        System.out.println("dp");
        for (int i=0;i<dp.length;i++) {
            for (int cap = 0; cap < dp[0].length; cap++) {
                System.out.print(" "+dp[i][cap]);
            }
            System.out.println();
        }
        for (int i=keep.length-1, j=keep[0].length-1;i>0;i--) {
            if (keep[i][j] == true) {
                res.add(profit[i]);
                j = j- weight[i];
            }

        }
        System.out.println(res);

    }
}
