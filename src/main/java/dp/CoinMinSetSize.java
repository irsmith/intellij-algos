package org.skup.dp;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

/**
 * Min setsize will be shortest path
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

/**
 * 
 * aha!! when using a cache, three things:! init it, read it and update it
 * aha!  when alloc cache, we want it to hold N+1 things prob.
 */
public class CoinMinSetSize {
	static int ca[];

	static Set<Integer> set = new HashSet<Integer>();
	static {
		set.add(1);
		set.add(2);
		set.add(3);
	}
	
 	
	static int minSet_iterative(Set<Integer> set, int i, int N) {
		// assert set has a one ?
		initCache(set,N);
		for (int k=1;k<=N;k++) {
            
			// find local min for all coins
			int candidate = 0;
			for (int c:set) {
				if (k-c > 0) {
                   candidate = ca[k-c];		
				}
			}
			candidate++; //
			System.out.println("candidate:"+candidate);
			// find min at K
			///int minatk = 1+ Math.min( Math.min(getCach(k-1), getCach(k-2)), getCach(k-3));
			

			// store min at K to cache
			
			ca[k]=candidate;

		}
		return ca[N];
	}

	private static void initCache(Set<Integer> set, int N) {
		ca = new int[N+1];  
		ca[0]=0;
		for (int i:set) {
			ca[i]=1;
		}
		
	}
	public static void main(String[] args) {
		Integer set2[] = { 1, 5, 10, 25 };

		assertEquals(1, minSet_iterative(set, set.size(), 1));
		assertEquals(1, minSet_iterative(set, set.size(), 2));
		assertEquals(2, minSet_iterative(set, set.size(), 4));

		assertEquals(5, minSet_iterative(set, set.size(), 11));



	}
}
