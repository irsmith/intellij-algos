package array;
import java.util.Arrays;

/*
 * Replace an array of numbers by the greatest number on the
 right hand side. Example: I/P: {2,6,7,4,3,2} O/P: {7,7,4,3,2,0}
 Explanation: The largest element to the right hand side of index
 0 is 7, so we place 7 in index 0. Likewise for index 1. There is
 no number to the right hand side of index 5, so we replace it
 with 0.
 */

public class FillHighestToRight {
	public static void main(String[] args) {
		int x = 5/3;
		System.out.println(x);
		Integer a[] = { 0, 1, 2, 3, 7, 0, 0, 4, 0, 1 };
		System.out.println(Arrays.asList(a));

		int highAtK = Integer.MIN_VALUE;
		int colorPaint = 0;
		int k = a.length - 1;
		while (k >= 0) {
			if ( a[k] > highAtK) {
				// if updating k, apply paint and load up color for next
				highAtK = a[k];
				a[k] = colorPaint;
				colorPaint = highAtK;
			} else {
				a[k] = colorPaint;
			}
			k--;

		}
		System.out.println(Arrays.asList(a));

	}
}
