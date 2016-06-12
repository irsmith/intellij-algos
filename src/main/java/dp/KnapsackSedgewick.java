
package  dp;
/******************************************************************************
 *  Compilation:  javac Knapsack.java
 *  Execution:    java Knapsack N W
 *
 *  Generates an instance of the 0/1 knapsack problem with N items
 *  and maximum weight W and solves it in time and space proportional
 *  to N * W using dynamic programming.
 *
 *  For testing, the inputs are generated at random with weights between 0
 *  and W, and profits between 0 and 1000.
 *
 *  %  java Knapsack 6 2000 
 *  item    profit  weight  take
 *  1       874     580     true
 *  2       620     1616    false
 *  3       345     1906    false
 *  4       369     1942    false
 *  5       360     50      true
 *  6       470     294     true
 *
 ******************************************************************************/

public class KnapsackSedgewick {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);   // number of items
        int W = Integer.parseInt(args[1]);   // maximum weight of knapsack

        int[] profit = new int[N+1];
        int[] weight = new int[N+1];

        // generate random instance, items 1..N
        for (int n = 1; n <= N; n++) {
            profit[n] = (int) (Math.random() * 1000);
            weight[n] = (int) (Math.random() * W) + 1; //allows zero weight
        }

        // dp[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does dp solution to pack items 1..n with weight limit w include item n?
        int[][] dp = new int[N+1][W+1];
        boolean[][] keep = new boolean[N+1][W+1];

        for (int i = 1; i <= N; i++) {
            for (int cap = 1; cap <= W; cap++) {

                // don't take item i
                int dontAccept = dp[i-1][cap];

                // take item i
                int accept = Integer.MIN_VALUE;
                if (weight[i] <= cap) accept = profit[i] + dp[i-1][cap - weight[i]];

                // select better of two options
                dp[i][cap] = Math.max(dontAccept, accept);
                keep[i][cap] = (accept > dontAccept);
            }
        }
        for (int i=0;i<keep.length;i++) {
            for (int cap = 0; cap < keep[0].length; cap++) {
                System.out.print(" "+keep[i][cap]);
            }
            System.out.println();
        }
        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (keep[n][w]) {
                take[n] = true;
                w = w - weight[n];
            }
            else           {
                take[n] = false;
            }
        }

        // print results
        System.out.println("capacity knapsac:" + W);

        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t" + profit[n] + "\t" + weight[n] + "\t" + take[n]);
        }
    }
}
