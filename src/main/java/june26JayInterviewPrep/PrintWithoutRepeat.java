package june26JayInterviewPrep;

import java.util.Random;

/**
 * given int[] print each w/out repeating
 * Time complexity O(n)
 */
public class PrintWithoutRepeat {
	static Random rnd = new Random();

	public static void main(String[] args) {
		int a[] = { 4, 3, 9, 78, 24, 5, 0, 77 };

		pv(a, 0, a.length - 1);

	}

	private static void pv(int[] a, int lo, int hi) {
		int length = hi - lo + 1;
		// base case
		if (length == 1) {
			System.out.format("%d %n",a[lo]);
			return;
		}
		int pv = rnd.nextInt(length) + lo;
		System.out.format("%d ",a[pv]);
        swap(a, lo, pv);
        pv(a, lo+1, hi);
	}

	private static void swap(int[] a, int lo, int hi) {
          int tmp=a[lo];
          a[lo] = a[hi];
          a[hi] = tmp;
	}

}
