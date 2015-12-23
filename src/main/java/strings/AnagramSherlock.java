package org.skup.strings;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSherlock {
	static class Res{
		int mapsz;
		int totalSubsets;
		public Res(int mapsz, int totalSubsets) {
			super();
			this.mapsz = mapsz;
			this.totalSubsets = totalSubsets;
		}
	}
	// http://stackoverflow.com/questions/29191565/find-the-number-of-unordered-anagramic-pairs-of-substrings
	public static void main(String[] args) {
		String a = "abba";
//		System.out.println(a.substring(0, 1));
//		System.out.println(a.substring(0, 2));
//		System.out.println(a.substring(0, 3));
//		System.out.println(a.substring(0, 4));

		Res rv = sherlock(a);
		System.out.println("nbr substrings excluding the string itself:" + rv.totalSubsets);

		System.out.println("map sizes:" + rv.mapsz);

	}

	private static Res sherlock(String a) {
		Map<String, List<Point>> m = new HashMap(); // point(x,y) = point (i,j)

		int cnt = 0;
		// find number of substrings. No shortcut here: is n-squared
		for (int i = 0; i < a.length(); i++) {
			for (int j = i + 1; j <= a.length() && (j-i) !=a.length(); j++) {
				String subs = a.substring(i, j);
				System.out.format(a.substring(i, j) + " at i=%d j=%d %n", i, j);
				char[] sorted = subs.toCharArray();
				Arrays.sort(sorted);

				subs = new String(sorted);
				if (m.containsKey(subs)) {
					System.out.format( "dup at i=%d j=%d %n", i, j-1);

					List<Point> plist = m.get(subs);
					plist.add(new Point(i, j-1));
				} else {
					List<Point> plist = new ArrayList<Point>();
					plist.add(new Point(i, j-1));
					m.put(subs, plist);
				}
				cnt++;
				
			}
		}
		return new Res(m.size(),cnt);
	}
}
