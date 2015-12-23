package june26JayInterviewPrep;

import java.util.HashMap;
import java.util.Map;

public class SmallestKsub3 {
	// find smallest subarray with K 1's
	public static void main(String[] args) {
		Integer a[] = { 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 };
		
		//Integer a[]  = { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }; // ! expected 4 actual 5
		//Integer a[]  = { 1, 1, 1, 1, 0, 0, 1 };

		System.out.println(smal(a, 4));

	}

	private static int smal(Integer[] a, int T) {

		// dont start coding until you have N solution

		// record first index where next one was seen:
		// 0 1 2 3 4 5 6 7 8
		// { 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 };
		// 1 1 2 2 3 4 4 5 .... hash-key
		// 0 2 4 5 7 ... hash val is the index

		// Find all with numeric distance K -1
		// find where 1 goes to 4, then where 2 goes to 5 , when where 3 goes to
		// 6...
		// Thus k = cum and value is first index of the bump-up
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();

		int cum = 0;
		for (int k = 0; k < a.length; k++) {
			if (a[k] == 1) {
				cum++;
				if (!m.containsKey(cum)) {
					m.put(cum, k);
				}
			}
		}
		// get k and k+(T-1) and the dist is end-beg.
		int mindist = Integer.MAX_VALUE;
		int key = 1;
		while (m.containsKey(key+T-1)) {
			int beg = m.get(key); // first one was at idx 0
			int end = m.get(key + T - 1); // fourth was at idx
			int dist = end - beg + 1;
			if (dist < mindist)
				mindist = dist;
			key++;
		}

		return mindist;
	}
}
