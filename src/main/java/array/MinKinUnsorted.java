package org.skup.array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinKinUnsorted {
	public static void main(String[] args) throws IOException {

		Integer[] _array = { 10, -2, -3, 0, 2, 12, 11 };
		Integer[]  v = { 10, -2, -3, 0, 2, 12, 11 };
		Integer[]  vv = { 10, -2, -3, 0, 2, 12, 11 };
		Integer[] c = { 10};

		int K = 3;
		List<Integer> res = kSmallest(K, c);
		System.out.println(res);
	}

	static List<Integer> kSmallest(int k, Integer[] a) {

		if (a.length <= k) return pkg(a,a.length-1);
		int lo = 0;
		int hi = a.length - 1;
		int pv = Integer.MAX_VALUE;
		while (k != pv) {
			pv = partition(a, lo, hi);
			System.out.println(Arrays.asList(a));

			//if (pv == k-1) return pkg(a, k-1);
			if (pv < k) {
				pv = partition(a, pv + 1, hi); // goto right
			} else {
				pv = partition(a, lo, pv - 1); // goto left
			}
		}
		return pkg(a,k-1);// Collections.emptyList();

	}

	private static List<Integer> pkg(Integer[] a, int k) {

		List<Integer> rv = new ArrayList<Integer>();
		for (int i=0;i<=k;i++) {
			rv.add(a[i]);
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

	private static void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static boolean less(Comparable comparable, Comparable v) {
		if (comparable.compareTo(v) < 0) {
			return true;
		} else
			return false;
	}

}
