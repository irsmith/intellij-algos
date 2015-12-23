package org.skup.dp;

import static org.junit.Assert.assertEquals;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
C() --> count()
                              C({1,2,3}, 5)                     
                           /                \
                         /                   \              
             C({1,2,3}, 2)                 C({1,2}, 5)
            /     \                        /         \
           /        \                     /           \
C({1,2,3}, -1)  C({1,2}, 2)        C({1,2}, 3)    C({1}, 5)
               /     \            /    \            /     \
             /        \          /      \          /       \
    C({1,2},0)  C({1},2)   C({1,2},1) C({1},3)    C({1}, 4)  C({}, 5)
                   / \      / \       / \        /     \    
                  /   \    /   \     /   \      /       \ 
                .      .  .     .   .     .   C({1}, 3) C({}, 4)
                                               /  \
                                              /    \  
                                             .      . *
 */
public class CoinNbrWays {

	static int count(Integer[] set, int i, int t) {
		if (t < 0)
			return 0; // no ways bec no solution exists
		if (t == 0)
			return 1; // one way to make 0 - do not include any coin

		// If there are no coins and n is greater than 0, then no solution exist
		if (set.length <= 0 && t >= 1)
			return -1;

		// count is sum of solutions (i) including S[i-1] (ii) excluding S[i-1]
		return count(set, i - 1, t) // including set[i-1]
				+ 
				count(set, i, t - set[i - 1]); //excluding set[i-1]

	}

	public static void main(String[] args) {

		Integer set[] = { 1, 5, 10};
		assertEquals(4, count(set, set.length, 11));

		
		// set[0...i-1] coins
		// we must go sorted order.  Thus in first iteration we exclude denom 25
		Integer set2[] = { 1, 5, 10, 25 };
		assertEquals(1, count(set2, set2.length, 1));

		
		
		
	}
}
