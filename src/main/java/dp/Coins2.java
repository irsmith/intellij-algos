package org.skup.dp;

import java.util.Arrays;

import org.junit.Assert;

/*
 * 
 * http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
 * f the currency system allows it, a simple greedy algorithm that takes as many of each coin as possible, 
 * starting with the highest value currency.

 Otherwise, dynamic programming is required to find an optimal solution quickly since this problem is essentially the knapsack problem.

 For example, if a currency system has the coins: {13, 8, 1}, the greedy solution would make change for 24 as {13, 8, 1, 1, 1},
  but the true optimal solution is {8, 8, 8}
 */
/**
 * Given denoms[1,5,10,25] and Target, list all ways to make change for Target
 * If denoms are sorted hi to low, then greedy solution started w highest denom.
 * Else use DP like 0/1 knapsack problem (vs. unbounded knapsack problem).
 * 
 * Variations: 
 * a. list all possible lists (this problem)
 * b. list Minimum set , eg. fewest coins or in knapsack problem, fill capacity to its best
 * c. count nbr ways
 * d. in 01knapsack, you dont have denom 1 and you want to "make change" whereby Target-capacity is minimized
 * 
 * @author issmith1
 *
 */
public class Coins2 {

	static int numWays(int T) {

		int num_ways[][] = new int[5][T + 1];

		// putting in zeroes to offset
		int getCents[] = { 0, 1, 5, 10, 25 }; // bug in stack overflow
		Arrays.fill(num_ways[0], 0);
		Arrays.fill(num_ways[1], 1);

		int current_cent = 0;
		for (int i = 2; i < num_ways.length; i++) {

			current_cent = getCents[i];

			for (int j = 1; j < num_ways[0].length; j++) {
				if (j - current_cent >= 0) {
					if (j - current_cent == 0) {
						num_ways[i][j] = num_ways[i - 1][j] + 1;
					} else {
						num_ways[i][j] = num_ways[i][j - current_cent] + num_ways[i - 1][j];
					}
				} else {
					num_ways[i][j] = num_ways[i - 1][j];
				}

			}

		}

		return num_ways[num_ways.length - 1][num_ways[0].length - 1];

	}

	public static void main(String[] args) {
		Assert.assertEquals(2, numWays(7));
		Assert.assertEquals(4, numWays(11));

		
	}

}
