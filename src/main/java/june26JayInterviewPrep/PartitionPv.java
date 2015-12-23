package june26JayInterviewPrep;

import java.util.Arrays;

public class PartitionPv {

	public static void main(String[] args) {
		int a[] = { 35, 42, 99, 2, 3, 0, 1, 44 }; // no! you cannot print arrays
													// only collections!
		System.out.println(Arrays.toString(a));
		qsort(a, 0, a.length - 1);

		System.out.println(a);

	}

	private static void qsort(int[] a, int lo, int hi) {
		int pv = partition(a, lo, hi);
		qsort(a, lo, pv - 1);
		qsort(a, pv + 1, hi);
		return;
	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo + 1; // OK start Before and pre increment. Check bounds after I visit
		int j = hi;
		int pv = a[lo];
		while (i <= j) {
			while (i < hi && a[i] < pv) { // while a[lo] is in place
				i++;
			}
			// while a[hi] is in place
			while (j > lo && a[j] > pv) { // while a[hi] is in place
				j--;
			}
			if (i>=j) break;
			swap(a, i, j);
			System.out.println(Arrays.toString(a));

		}
		swap(a, lo, j);
		System.out.println("END  "+Arrays.toString(a));

		return j;
	}

	private static void swap(int[] a, int lo, int hi) {
		System.out.format("swap lo:%d, hi%d, %n", lo, hi);

		int tmp = a[lo];
		a[lo] = a[hi];
		a[hi] = tmp;
	}
}
