package june26JayInterviewPrep;

import java.util.Arrays;

/**
 * Iterative is usually bottom up and recursive top down
 * 
 *
 */
public class MergeIterative {
	public static void main(String[] args) {

		int test[] = {0,2,4,6,1,3,5,7,9};
		merge(test, 0, 4, 8);
		System.out.println(Arrays.toString(test));
			
		int a[] = { 4, 3, 6, 8, 2, 9, 12, 0 };
		
		sortIterative(a);
	}

	private static void sortIterative(int[] a) {
		if (a.length == 1)
			return;
		int length = 1;
		while (length < a.length) {
			length = length * 2;

			// merge from 0 to length (except last hunk which is 0 to a.len-1
			int stop = ((a.length / length) * length) + length;
			for (int start = 0; start < stop; start = start + length) {
				int end = ((start+length)*2) - 1;
				merge(a, start, start + length,Math.max(end,a.length-1));
			}

		}
	}

	private static void merge(int[] a, int lo, int mid, int hi) {
		int[] tmp = new int[a.length];
		for (int j = 0; j < a.length; j++) {
			tmp[j] = a[j];
		}
		int i = lo;
		int j = mid;
		int k = 0;
		while (k < a.length) {

			if (i >= mid) {
				a[k++] = tmp[j++];
			} else if (j >= hi) {
				a[k++] = tmp[i++];
			} else if (tmp[i] < tmp[j]) {
				a[k++] = tmp[i++];
			} else {
				a[k++] = tmp[j++];
			}
		}

	}
}
