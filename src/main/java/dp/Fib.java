package org.skup.dp;

import static org.junit.Assert.*;

import java.util.Arrays;

public class Fib {

	public static void main(String[] args) {
		assertEquals(5, f(5));
		assertEquals(13, f(7));
		assertEquals(34, f(9));

	}

	private static long f(int n) {
		long rv = -1;
        long ca[] = new long[n+1]; //NO!! only need past 2 elements
        Arrays.fill(ca, -1);  // dont need this either
        ca[0] = 0;
        ca[1] = 1;
        long p;//prev
        long pp;//prev-prev
        for (int i=2;i<=n;i++) {
        	p=ca[i-1]; pp=ca[i-2];
        	rv = p + pp;
        	ca[i] = rv;
        	//if (ca[i] != -1) 
        }
		return rv;
	}
}
