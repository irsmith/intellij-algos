package org.skup.dp;

import static org.junit.Assert.*;

public class ChildSteps {

	// copied from CTCI
	static int countWays(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);

	}

	// generaliz to N denominations
	static int countWays2(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		// total ways is ways for remainder when 1 is selected first plus..
		// ways for remainder when 2 is selected first...
		// whereby we go ahead an descend into negative numbers.
		// If we tried to exclude neg. at this point, java gets mad that we
		// are not returning a value.

		int tot = 0;
		for (int j = 1; j < 4; j++) {
			tot += countWays2(n - j);
		}
		return tot;

	}

	// memoize
	static int[] cach = new int[100];
	static {
		for (int i = 0; i < 100; i++)
			cach[i] = -1;
	}

	static int countWays_mem(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		if (cach[n] != -1)
			return cach[n];
		// total ways is ways for remainder when 1 is selected first plus..
		// ways for remainder when 2 is selected first...
		// whereby we go ahead an descend into negative numbers.
		// If we tried to exclude neg. at this point, java gets mad that we
		// are not returning a value.

		int tot = 0;
		for (int j = 1; j < 4; j++) {
			tot += countWays_mem(n - j);
		}
		cach[n] = tot;
		return tot;
	}

	public static void main(String[] args) {
		assertEquals(1, countWays2(0)); // this base case is hard to get head around -- there is one way to make change
		assertEquals(1, countWays2(1));
		assertEquals(2, countWays2(2));

		assertEquals(4, countWays2(3));
		assertEquals(7, countWays2(4)); // = f(4-1)+f(4-2)+f(4-3) = sum of prev. three
		assertEquals(13, countWays2(5));

		assertEquals(755476, countWays2(23));
		assertEquals(1389537, countWays2(24));
		long start = System.currentTimeMillis();
		assertEquals(181997601, countWays2(32));
		System.out.println("TIM1: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		assertEquals(334745777, countWays2(33));
		System.out.println("TIM2: " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		assertEquals(1132436852, countWays_mem(35));
		System.out.println("TIM1: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		assertEquals(2082876103, countWays_mem(36));
		System.out.println("TIM2: " + (System.currentTimeMillis() - start));

	}
}
