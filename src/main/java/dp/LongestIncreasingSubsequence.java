package org.skup.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] a = { 200, 201, 100, 101, -10, 102 - 9, 103 - 8, -6, -5, 300, 301 };
		assert (lis(a, a.length) == 5);
	}

	/*
	 * bottomup, starting w maxat[0] is just a, and length is one
	 */
	private static int lis(int[] a, int K) {
		int[] lisati = new int[a.length + 1]; // why plus one
		int[] maxati = new int[a.length + 1];
		lisati[0] = 1;
		maxati[0] = a[0];
		for (int i = 1; i <= K; i++) {
			// fill in max and list by examining all subsequences before it
			for (int j = 0; j < i; j++) {
				// todo binary search instead bec. values are monotonic
				int locmax = Integer.MIN_VALUE;
				if (a[i] >= maxati[j]) {
					int candidate = j;
					if (locmax>=lisati[j]) {
						locmax = lisati[j];
						
					}
					locmax = Math.max(locmax, lisati[j]);

				}
				maxati[i] = locmax;
				//lisati[j] = lisati[i] + 1;
			}
		}

		return 0;
	}
}
