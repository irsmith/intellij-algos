package org.skup.array;

import java.util.HashMap;
import java.util.Map;

public class SmallestKsub3 {
	// find smallest subarray with K 1's
	public static void main(String[] args) {
		Integer a[] = { 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1 };

		Integer a2[] = { 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 };
		
		//Integer a[]  = { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }; // ! expected 4 actual 5
		//Integer a[]  = { 1, 1, 1, 1, 0, 0, 1 };

		System.out.println(smal(a, 4));

	}

	private static int smal(Integer[] a, int T) {

		// record LAST index where next one was seen;
		// a map is perfect for this because it overwrites
		// Then on second walk of the map, find GAP bw keys is T-1 then use
		//corresponding values to calc. distance.
		
		// if your map key was the FIRST index that cum changed then walk forward
		// whereby GAP is cur + T-1
		
		// 0 1 2 3 4 5 6 7 8
		// { 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 };
		//{1=0, 2=2, 3=4, 4=5, 5=7, 6=8, 7=9, 8=12}   #last seen


		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int cum = 0;
		for (int k = 0; k < a.length; k++) {
			if (a[k] == 1) {
				cum++;
				if (!m.containsKey(cum)) {  // save FIRST occurrence
					m.put(cum, k);
				}
			}
		}
		System.out.println(m);
		int mindist = Integer.MAX_VALUE;
		for (int begkey: m.keySet()) {
			int endkey = begkey +  T - 1; 
			if (!m.containsKey(endkey))break;

			int begidx = m.get(begkey); 
			int endidx = m.get(endkey);
			
			int dist = endidx - begidx ;
			System.out.format("new dist: %d begkey %d endkey %d %n", dist, begkey, endkey);
			if (dist < mindist)
				mindist = dist;
		}

		return mindist;
	}
}
