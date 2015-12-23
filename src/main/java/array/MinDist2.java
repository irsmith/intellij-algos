package org.skup.array;

import java.util.Arrays;

public class MinDist2 {
	public static void main(String[] args) {
		/**
		 * Given an array of Integers & given pair of values, find the minimum distance bw 
		 * given pair of numbers. For example in the array {1,3,6,2,7,9,8,2},
		 * the minimum distance between (3,9) is 3 because 3 is at index 1 and 9
		 * is at index 4. Likewise the minimum distance between (2,8) is 1
		 * because 8 is at index 6 and 2 is at index 7 (it is also at index 3
		 * but we want the minimum distance).
		 */
		Integer a[] = { 2, 3, 6, 2, 7, 9, 8, 0, 2, 8 };
		System.out.println(Arrays.toString(a));
		System.out.println(mindist(a, 2, 8));
	}

	private static int mindist(Integer[] a, int A, int B) {
		int mindist = Integer.MAX_VALUE;
		int lastAidx = -1;
		int lastBidx = -1;

		for (int k = 0; k < a.length; k++) {
			if (a[k] == A) {
				lastAidx = k;
				mindist = updMindist(lastAidx, lastBidx, mindist);
			}
			if (a[k] == B) {
				lastBidx = k;
				mindist = updMindist(lastAidx, lastBidx, mindist);
			}
		}
		return mindist;
	}

	private static int updMindist(int lastAidx, int lastBidx, int mindist) {

		if (lastAidx == -1 || lastBidx == -1)
			return mindist;

		int abs = Math.abs(lastAidx - lastBidx);
		return abs < mindist ? abs : mindist;
	}

}
