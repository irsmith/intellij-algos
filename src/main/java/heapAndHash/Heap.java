package heapAndHash;

import heapAndHash.Heap.Type;

import java.util.Arrays;

/*************************************************************************
 *  Compilation:  javac Heap.java
 *  Execution:    java Heap < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/24pq/tiny.txt
 *                http://algs4.cs.princeton.edu/24pq/words3.txt
 *  
 *  Sorts a sequence of strings from standard input using heapsort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Heap < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Heap < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 *************************************************************************/

/**
 * The <tt>Heap</tt> class provides a static methods for head ds
 */
public class Heap {
	int N;
	Comparable[] pq;

	enum Type {
		max, min
	};

	static Type type;

	// This class should not be instantiated.
	public Heap(Type t, Comparable[] pq) {
		type = t;
		this.pq = pq;
		N = pq.length;
		pq = new Comparable[N + 1];// off by one
		insert(this.pq);
	}

	public Heap(Type t) {
		type = t;
	}

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param pq
	 *            the array to be sorted
	 */
	public static void insert(Comparable[] pq) {
		int N = pq.length;
		for (int k = N / 2; k >= 1; k--)
			sink(pq, k, N);
		// show(pq);
	}

	/***********************************************************************
	 * Helper functions to restore the heap invariant.
	 **********************************************************************/

	private static void sink(Comparable[] pq, int k, int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(pq, j, j + 1))
				j++;
			if (!less(pq, k, j))
				break;
			exch(pq, k, j);
			k = j;
		}
	}

	/***********************************************************************
	 * Helper functions for comparisons and swaps.
	 * Indices are "off-by-one" to support 1-based indexing.
	 **********************************************************************/
	private static boolean less(Comparable[] pq, int i, int j) {
		if (type == Type.max) {
			return pq[i - 1].compareTo(pq[j - 1]) < 0;
		} else {
			return pq[i - 1].compareTo(pq[j - 1]) > 0;
		}
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		if (type == Type.max) {
			return (v.compareTo(w) < 0);
		} else {
			return (v.compareTo(w) > 0);
		}
	}

	/***********************************************************************
	 * Check if array is sorted - useful for debugging
	 ***********************************************************************/
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.asList(a[i]));
		}
	}

	/**
	 * Reads in a sequence of strings from standard input; heapsorts them;
	 * and prints them to standard output in ascending order.
	 */
	public static void main(String[] args) {
		String[] a = { "apple", "pear", "b", "orange", "kiwi", "d", "e" };
		Heap h = new Heap(Type.max, a);
		show(a);
		String b[] = { "apple", "pear", "b", "orange", "kiwi", "d", "e" };
		System.out.println();
		Heap h2 = new Heap(Type.min, b);
		show(b);
	}
}
