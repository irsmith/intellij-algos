package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindKthSmallest2 {
	// find smallest subarray with K 1's
	public static void main(String[] args) {
		Integer a[] = { 11, 0, -1, 0, 1, 21, 13, 31, 0, -2 };
		Integer b[] = { 11, 0, -1, 0, 1, 21, 13, 31, 0, -2 };
		Integer c[] = { 11, 0};

		Integer[] r = smal(a, 4);
		System.out.println(Arrays.asList(r));
	}

	private static Integer[] smal(Integer[] a, int K) {

		if (a.length <= K || K > a.length)
			return a;
		int lo = 0;
		int hi = a.length - 1;
		int pv = Integer.MAX_VALUE;
		while (pv != K) {
			pv = partition(a, lo, hi);
			if (pv < K) {
				// search right
				pv = partition(a, pv + 1, hi);
			} else {
				pv = partition(a, lo, pv - 1);
			}
		}
		Integer[] below = pkg(a, K-1);

		System.out.format("below: %s a[K]:%d %n", Arrays.asList(below),a[K]);
		return pkg(a, K-1);
	}

	private static Integer[] pkg(Integer[] a, int k) {
		Integer[] rv = new Integer[k];
		for (int i = 0; i < k; i++) {
			rv[i] = a[i];
		}
		return rv;
	}

	// http://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Quick.java.html
	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			// find item on lo to swap
			while (less(a[++i], v))
				if (i == hi)
					break;

			// find item on hi to swap
			while (less(v, a[--j]))
				if (j == lo)
					break; // redundant since a[lo] acts as sentinel

			// check if pointers cross
			if (i >= j)
				break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
