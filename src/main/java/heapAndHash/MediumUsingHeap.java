package heapAndHash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class MediumUsingHeap {
	static PriorityQueue<Integer> minq = new PriorityQueue<Integer>(); // natural ordering is low to hi
	static PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(100, new Max());

	
	// reverse sorting order
	static class Max implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// return? compare(o2,o1);//NO!!!
			return o2.compareTo(o1);
		}

	}

	public static void main(String[] args) {

		Integer[] a = new Integer[] { 8, 1, 10, 11, 2, 3, 9, 7 };
	
		minq.addAll(Arrays.asList(a));
		System.out.println(minq);

		maxq.addAll(Arrays.asList(a));
		System.out.println(maxq);

		// demo that array is not fully sorted but the removes are
		for (int i = 0; i < a.length; i++) {
			System.out.println(minq.remove());
			System.out.println(minq);
		}

		int rv = findMedium(a);
		System.out.println(rv);
	}

	private static int findMedium(Integer[] a) {
		if (a.length == 0)
			return -1;
		if (a.length == 1)
			return a[0];

		minq.add(a[0]);

		for (int i = 1; i < a.length; i++) {
			if (minq.size() == maxq.size()) {
				addTopHalfNbrToMinq(a[i]);
			} else {
				addToBott(a[i]);
			}
		}

		if (a.length % 2 == 0) {
			int mid = a.length / 2;
			int medium = (a[mid] + a[mid + 1]) / 2;
			return medium;
		} else {
			return a[a.length / 2];
		}
	}

	/*
	 * add to min q.  BUT minq.peek but Always be higer than maxq.peek.
	 * So compare maxq.peek with candidate
	 */
	private static void addTopHalfNbrToMinq(Integer candidate) {
		int accepted = -1;
		if (candidate > maxq.peek()){
			minq.add(candidate);
		} else {
			//violation: minq will grow by getting
			int tmp = maxq.remove();
			minq.add(tmp);
			maxq.add(candidate);
		}
		
		
		// if violates being in top half of numbers, adjust by pop minq, push to maxq, then add to top
		if (candidate < minq.peek()) {
			// candidate should endup in bottom / maxq
			int tmp = minq.remove();
			maxq.add(tmp);
			minq.add(candidate);
		}
		
		minq.add(accepted);
		assertTrue(minq.size() > maxq.size());
	}

	private static void addToBott(Integer integer) {
		
		
		assertTrue(minq.size() == maxq.size());
	}
}
