package strings;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TwoStrings {

	/*
	 * For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO. arg! trick
	 * question -- if greatest common substring then need suffix array but if any substring, then any common character.
	 * For latter , O(m) where m is shortest word -- use 2 pointers and scan each letter of each word. For former, write
	 * compare string algo that ignores '#'
	 * http://cs.stackexchange.com/questions/9555/computing-the-longest-common-substring
	 * -of-two-strings-using-suffix-arrays
	 * 
	 * 2 hello world hi world
	 * 
	 * YES NO
	 */
	public static void main(String[] args) throws FileNotFoundException {
		test();
		//testReadFile();
		String hard="/tmp/twostring.txt";
		String easy="target/classes/org/skup/strings/simple.txt"; // youre kidding!
		Scanner s = new Scanner(new File(easy));// System.in);
		int cnt = Integer.parseInt(s.nextLine().trim());
		while (cnt > 0) {
			cnt--;
			String w = s.nextLine().trim() + "#" + s.nextLine().trim();
			System.out.println(f(w));
		}
		s.close();
	}

	private static void testReadFile() {
		String hard="/tmp/twostring.txt";
		String easy="org/skup/strings/simple.txt";
		File directory = new File(".");
		   File[] contents = directory.listFiles();
		   System.out.println(contents);
		
	}

	private static void test() {
		IgnoreHashComparator ig = new IgnoreHashComparator();
		assertEquals( (ig.compare("a", "a")),0);
		assertEquals( (ig.compare("a", "b")) , -1);
		assertEquals( (ig.compare("aaa", "a#aa")) ,0);


	}

	static class IgnoreHashComparator implements Comparator<String> {
		public int compare(String a, String b) {
			int alen = hashash(a) ? a.length() - 1 : a.length();
			int blen = hashash(b) ? b.length() - 1 : b.length();

			for (int i = 0; i < Math.min(alen, blen); i++) {
				char c1 = a.charAt(i) == '#' ? a.charAt(++i) : a.charAt(i);
				char c2 = b.charAt(i) == '#' ? b.charAt(++i) : b.charAt(i);

				if (c1 < c2) {
					return -1;
				} else if (c1 > c2) {
					return +1;
				}
			}
			return 0;
		}
	}

	private static String f(String w) {
		// put in arr of string then sort
		List<String> suff = new ArrayList<String>();// w.length()];
		for (int i = 0; i < w.length(); i++) {
			suff.add(w.substring(i));
		}
		suff.sort(new IgnoreHashComparator());

		for (int i = 1; i < w.length(); i++) {
			String w1 = suff.get(i - 1);
			String w2 = suff.get(i);
			if (w1.charAt(0) == w2.charAt(0)) {
				if (hashash(w1) && !hashash(w2) || (!hashash(w1) && hashash(w2))) {
					return "YES";
				}
			}

		}
		return "NO";
	}

	private static boolean hashash(String w2) {
		return w2.indexOf('#') >= 0;
	}
}
