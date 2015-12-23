package org.skup.dp;

import java.awt.Point;
import java.util.Arrays;

public class MatrixFindPaths {

	/**
	 * given matrix h x w, count all paths from point(0,0) to T target
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int height = 4;
		int width = 3;
		int rv = findp(width, height, new Point(3, 2)); // x y

	}

	private static int findp(int width, int height, Point t) {

		int m[][] = new int[height][width];
		Arrays.fill(m[0], 1);
		for (int r = 0; r < height; r++) {
			m[r][0] = 1;
		}
		boolean done = false;
		Point p = new Point(0, 0);// c, r
		int newrow = p.y;
		int newcol = p.x;

		while (!done) {

			if (p.x <= t.x && p.y <= t.y) {
				newrow++;
				newcol++;
				
				m[p.y + 1][p.x]=m[p.y ][p.x] + 1; //next row gets (prev row+1)
						
				m[p.y][p.x+1]=m[p.y ][p.x] + 1; //next c increments by one
				m[p.y][p.x+1]=m[p.y ][p.x] + 1; //kitty increments by sum 


			} else if (p.x <= t.x) {

			}
           if (t == p) done = true;
		}
		for (int r = 0; r < t.y; r++) {
			for (int c = 0; c < t.x; c++) {
				// m[r][c] = -1;
			}
		}

		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				System.out.print(m[r][c] + " ");
			}
			System.out.println();
		}

		return 0;
	}
}
