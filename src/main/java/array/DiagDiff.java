package org.skup.array;

import java.util.Scanner;

/**
 * 
3
11 2 4
4 5 6
10 8 -12
 * @author irene
 *
 */
public class DiagDiff {

	static int calc(int[][] a, int N) {
		int maj = 0;
		int min = 0;
		for (int r = 0; r < N; r++) {
			maj = maj + a[r][r];
		}
		for (int r = 0; r < N; r++) {
			for (int c = N - 1; c >= 0; c--) {
				min = min + a[r][c];
			}
		}

		return Math.abs(maj - min);
	}

	public static void main(String[] args) {
		int arr[] = null;// {4};
		arr = null;
		
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine());
		int[][] a = new int[N][N];
		for (int r = 0; r < N; r++) {
			String line = s.nextLine();
			String l[] = line.split(" ");
			for (int c = 0; c < N; c++) {
				a[r][c] = Integer.parseInt(l[c]);
			}
		}
		int rv = calc(a, N);
		System.out.println(rv);
	}
}
