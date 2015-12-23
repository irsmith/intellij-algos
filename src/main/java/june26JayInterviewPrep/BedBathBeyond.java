package june26JayInterviewPrep;

import org.junit.Assert;

public class BedBathBeyond {

	static int iterationCnt=0;
	static boolean hasall(String[] dict, String s) {
		if (s==null || s.isEmpty()) return false;
		return hasall_h(dict, s);


	}
	static boolean hasall_h(String[] dict, String s) {
		iterationCnt++;
		// base case
		if (s.length() <= 0) return true;
		for (String word : dict) {
			if (s.startsWith(word))                 System.out.println("found "+word);


			if (s.startsWith(word) && hasall_h(dict, s.substring(word.length()))) {
				return true;
			}
		}
		return false;

	}

	static int rank(String[] a, String s) {

		return rank_h(a, s, 0, a.length - 1);
	}

	private static int rank_h(String[] a, String s, int lo, int hi) {
		int mid = -1;

		while (lo <= hi) {
			mid = lo + ((hi - lo) / 2);
			int cmp = s.compareTo(a[mid]);

			if (cmp == 0) {
				return mid;
			} else if (cmp < 0) {
				// mid = rank_h(a, s, lo, mid - 1);
				hi = mid - 1;
			} else {
				// mid = rank_h(a, s, mid + 1, hi);
				lo = mid + 1;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		String[] a2 = { "apple", "banana", "cactus", "fig", "guava", "pear", "tomato", "Bed", "Bath", "Beyond" };
		String[] a = { "Bed", "Bath", "Beyond" };

		Assert.assertFalse(hasall(a2,"") );
		Assert.assertFalse(hasall(a2,null) );

		Assert.assertTrue(hasall(a2,"BedBathBeyond") );
		Assert.assertFalse(hasall(a2,"BedxBathBeyond") );
		Assert.assertTrue(hasall(a2,"cactuscactuscactus") );

        System.exit(0);
		Assert.assertTrue("cactus".compareTo("fig") < 0);
		Assert.assertTrue("fig".compareTo("cactus") > 0);

		Assert.assertEquals(3, rank(a, "fig"));

		Assert.assertEquals(2, rank(a, "cactus"));
	}
}
