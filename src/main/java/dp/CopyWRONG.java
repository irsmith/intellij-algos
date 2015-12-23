package org.skup.dp;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CopyWRONG {

	static Set<Integer> coinset = new HashSet<Integer>(Arrays.asList(25,10,5,1));//not time efficient but compact
	//http://stackoverflow.com/questions/12962193/creating-subset-of-a-set-in-java
	// I am using list which has subList since java Set does not have subSet
	static List<Integer> coins = new ArrayList<Integer>();
    static {
		coins.add(1);
		coins.add(5);
		coins.add(10);
		coins.add(25);
	}
	

	static int f(int t, List<Integer> set) {
		if (set.size() == 1 && set.iterator().next() == t) return 1;
		
		List<Integer> reducedSet = set.subList(1, set.size()-1);
		
		int waysUsingFirstElem = f(t-set.iterator().next(), reducedSet);
		
		int waysWithouFirstElem = f(t, set);
        return waysWithouFirstElem + waysUsingFirstElem;
	}
	public static void main(String[] args) {

		assertEquals(1, f(1, coins));
		assertEquals(1, f(2, coins));
		assertEquals(1, f(3, coins));
		assertEquals(1, f(4, coins));

		assertEquals(2, f(5, coins)); // ways to make 4 + 1
		
	}
}
