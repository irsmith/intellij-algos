package org.skup.array;

import java.util.Arrays;


/*
 * 
 Given an array of Integers, find the longest increasing sub-sequence
 {1,6,2,3,4, 2,5}.
 The longest increasing sequence is 1,2,3,4,5.
 http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
	static int[] lisAtK = null;
	static int[] maxAtK = null;

	public static void main(String[] args) {
		int[] b = { -6, 2, -5, 4, -4, 5, -3 };
		int[] b2 = { -6, 2, -5, 4, -4, 5, -3, 7, 8 };

		int[] a = { 0, 1, 2, 3, 0, 1, 2, 3, 4, 5, 0, 2, 3, 0 };
		// 01 3 4 5 6 7 8 9 11 13
		int[] c = { 1, 6, 2, 3, 0, 0, 0, -4, -3, -2, -1, 0 };
		int[] d = { 1, 6 };
		int[] e = { 1, -2 };
		int[] f = {};
		int[] g = { 1 };

//		Assert.assertEquals(1, lis_helper(e));
//
//		Assert.assertEquals(4, lis_helper(b));
//		Assert.assertEquals(5, lis_helper(b2));
//		Assert.assertEquals(0, lis_helper(f));
//
//		Assert.assertEquals(1, lis_helper(g));
//
//		// 0 1 2 3 4 5 6 7 8 9 10 11 12
//		Assert.assertEquals(5, lis_helper(c));
//
//		Assert.assertEquals(6, lis_helper(a));
//		Assert.assertEquals(5, lis_helper(b));

	}

	private static int lis_helper(int[] a) {
		if (a.length == 0)
			return 0;
		lisAtK = new int[a.length];
		lisAtK[0] = 1;
		// maxAtK = new int[a.length];
		return calcMaxAtK(a);
	}

	private static int calcMaxAtK(int[] a) {
		for (int k = 0; k < a.length; k++) {
			int localLISmax = Integer.MIN_VALUE;
			for (int j = 0; j < k; j++) {
				int tightLIS = -1;

				if (a[j] < +maxAtK[j]) {
					// violates
					tightLIS = 1;
				} else {
					tightLIS = 1 + lisAtK[j]; // accept
				}
				localLISmax = Math.max(localLISmax, tightLIS);
			}
			lisAtK[k] = localLISmax;
		}
		// http://professorjava.weebly.com/longest-increasing-subsequence.html
		System.out.println("REs" + Arrays.asList(lisAtK).toString());
		return lisAtK[a.length - 1];
	}
}
