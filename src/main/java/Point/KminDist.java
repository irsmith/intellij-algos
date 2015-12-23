package org.skup.Point;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KminDist {

	public static void main(String[] args) {
		
		//given set points, find K min distance
		Set<Point> set = new HashSet<Point>();
		set.add(new Point(1,1));
		set.add(new Point(1,3));
		set.add(new Point(3,1));
		set.add(new Point(1,4));
		set.add(new Point(1,5));
		set.add(new Point(5,5));
        List<Point> answ = minK(3, set);
        System.out.println(answ.toString());

	}
//Exception in thread "main" java.lang.ClassCastException: org.skup.Point.KminDist$Rec cannot be cast to java.lang.Comparable

	static class Rec implements Comparable<Rec> {
		Double key;
		Point point;
		@Override
		public int compareTo(Rec o) {
			return key.compareTo(o.key);
		}
	}
	private static List<Point> minK(int K, Set<Point> in) {
		PriorityQueue<Rec> pq = new PriorityQueue<Rec>();
		for (Point p:in) {
			Rec r = new Rec();
			r.key = Math.pow(p.x,2)+Math.pow(p.y, 2);
			r.point = p;
		    pq.add(r);	
		}
		List<Point> answ = new ArrayList<Point>();
		for (int k = 0;k<K;k++) {
			answ.add(pq.remove().point);
		}
		return answ;
	}
}
