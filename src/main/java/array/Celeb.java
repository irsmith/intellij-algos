package org.skup.array;

import java.awt.Point;
import java.util.Random;

public class Celeb {

	/*
	 * rule0: eveyone knows hisself
	 * rule1: everyone knows the celeb
	 * rule2: celeb knows no one (except himself)
	 * Cannot have celeb1 and celeb2 bec. then celeb2 would have to know celeb1 which violates rule1
	 */
	public static void main(String[] args) throws Exception {

		boolean a[][] = { 
				{ true, false, false, false }, 
				{ false, true, true, false }, 
				{ true, false, true, false },
				{ true, false, false, true }, };
		int N = a.length;
		boolean elim[] = new boolean[N];
		int plays = 0;
		Point cur = new Point(0, 0); // getPlay(cur);
		while (cur.y < N) {
			while (cur.x < N) {
				System.out.format("val is %b at y=%d,x=%d ",a[cur.y][cur.x],cur.y,cur.x);
                cur.x += 1;
			}
			System.out.println();
			cur.y += 1;
			cur.x = 0;
		}
		
		cur = new Point(0, 0); // getPlay(cur);
		while (plays < N) {
			if (cur.x == cur.y) {
				// if row==col go to next increment Point by col+1
				cur = new Point(cur.x + 1, cur.y); // increment col+1
			} else if (a[cur.y][cur.x] == true) {
				// if Point cur == true then cur knows someone not himself, SO {elim cur, increment cur by row+1)
				elim[cur.y] = true;
				cur = new Point(cur.x, cur.y + 1); // increment cur by row +1
			} else {
				// else cur NOT knows someone not himself, SO { increment cur by col+1}
				cur = new Point(cur.x + 1, cur.y); // increment col+1
			}
			plays++;
		}
		for (int k = 0; k < N; k++) {
			if (elim[k] == false) {
				System.out.println("winner is: " + k);
				System.exit(0);
			}
		}

	

	}

	static Point getPlay(Point p) {
		if (p == null)
			return new Point(0, 1);
		return null;
	}
}
