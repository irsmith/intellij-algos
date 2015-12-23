package june26JayInterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDist {
	public static void main(String[] args) {
		/**
		 * Given an array of Integers, find the minimum distance between the
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
		List<Integer> posA = new ArrayList<Integer>();
		List<Integer> posB = new ArrayList<Integer>();
		for (int k = 0; k < a.length; k++) {
			if (a[k] == A) {
				posA.add(k);
			}
			if (a[k] == B) {
				posB.add(k);
			}
		}
		return merge(posA.toArray(new Integer[posA.size()]),
				posB.toArray(new Integer[posB.size()]));
	}

	private static int merge(Integer[] posA, Integer[] posB) {
		if (posA.length == 0 || posB.length == 0)
			return -1;
		int mindist = Integer.MAX_VALUE;
		int A = -1, B = -1;
		// upon each selection update mindist
		int i = 0, j = 0;
		while (i < posA.length  || j < posB.length ) {
			if (i >= posA.length) {
				B = posB[j++];
				mindist = updMin(A, B, mindist);

			} else if (j >= posB.length) {
				A = posA[i++];
				mindist = updMin(A, B, mindist);

			} else if (posA[i] < posB[j]) {
				A = posA[i++];
				mindist = updMin(A, B, mindist);
			} else {
				B = posB[j++];
				mindist = updMin(A, B, mindist);

			}
		}

		return mindist;
	}

	private static int updMin(int A, int B, int cur) {
		if (A == -1 || B == -1)
			return cur;;
		int dist = Math.abs(A - B);
		return (cur > dist) ? dist : cur;

	}
}
