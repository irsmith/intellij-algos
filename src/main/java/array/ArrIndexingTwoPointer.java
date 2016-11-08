package array;

import java.util.Arrays;

public class ArrIndexingTwoPointer {
	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 3, 4, 5, 6 }; // odd length n
		boolean odd = a.length % 2 == 1;
		System.out.println("odd? "+odd);
		int N = a.length;

		// for loop from 1 to end
		System.out.println(Arrays.toString(a));
		for (int lo = 1, hi = N - 1; lo < hi; lo++, hi--) {
			System.out.format("lo=%d, hi=%d %n", lo, hi);
		}
		System.out.format("exited FOR , last cur lo=3, hi=4 %n ");

		// while loop increment at end
		int lo = 1, hi = N - 1;
		while (lo < hi) {
			System.out.format("lo=%d, hi=%d %n", lo, hi);
			lo++;
			hi--;
		}
		System.out.format("exited WHILE-increment-at-bottom lo=%d, hi=%d %n", lo, hi);

		// while loop increment top
		lo = 0; // start lower
		hi = N; // start higher
		while (lo < hi) {
			lo++;
			hi--;
			System.out.format("lo=%d, hi=%d %n", lo, hi);
		}
		System.out.format("exited WHILE-increment-top lo=%d, hi=%d %n", lo, hi);
	}
}
