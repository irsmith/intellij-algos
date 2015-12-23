package org.skup.dp;

import static org.junit.Assert.*;

//https://www.youtube.com/watch?v=PLJHuErj-Tw
//https://www.youtube.com/watch?v=EH6h7WA7sDw

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
//	 N = Integer.parseInt(args[0]);   // number of items
//     int W = Integer.parseInt(args[1]);   // maximum weight of knapsack

    public static void main(String[] args) {
    	assertEquals("todo",f(4, 5));

//    	assertEquals("todo",f(6, 2000));
         
    }
    static  String f(int N, int W) {
        int[] profit = {3,7,2,9};//new int[N+1];
        int[] weight ={2,3,4,5};// new int[N+1];

        // generate random instance, items 1..N
        for (int n = 1; n <= N; n++) {
            profit[n] = (int) (Math.random() * 1000);
            weight[n] = (int) (Math.random() * W);
        }

        // opt[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        
        
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) option2 = profit[n] + opt[n-1][w-weight[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) { take[n] = true;  w = w - weight[n]; }
            else           { take[n] = false;                    }
        }
        
        int optWidth = opt[0].length;
        int optLength = opt.length;
        
        System.out.format("OPT w:%d len:%d %n",optWidth,optLength);
        for (int i=0;i<N;i++) {
        	for (int j=0;j<W;j++) {
        		System.out.print(opt[i][j]  + " ");
        	}
        }

        System.out.format("SOL w:%d len:%d %n",sol[0].length, sol.length);
        for (int i=0;i<N;i++) {
        	for (int j=0;j<W;j++) {
        		System.out.print(sol[i][j]  + " ");
        	}
        }
        StringBuilder rv = new StringBuilder("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            rv.append(n + "\t" + profit[n] + "\t" + weight[n] + "\t" + take[n]);
        }
        return rv.toString();
    }
}
