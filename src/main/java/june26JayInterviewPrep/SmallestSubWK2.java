package june26JayInterviewPrep;

public class SmallestSubWK2 {
	static class Res {
		int strt;
		int end;

		@Override
		public String toString() {
			return String.format("Res:start %d End %d %n", strt, end);
		}
	}

	// find smallest subarray with K 1's
	public static void main(String[] args) {
		Integer a[] = { 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 };
		System.out.println(smal(a, 4));

	}

	private static Res smal(Integer[] a, int T) {

		int ld = 0, lg = 0;
		int minSoFar = Integer.MAX_VALUE;
		// at each element look left and right until hit target then save min
		Res r = new Res();
		for (int k = 0; k < a.length; k++) {
			if (minSoFar == T)
				break; // cannot get better than this
			ld = lg = k;  // two pointer lead an lag; lead looks backwards one, lead looks fwd one.
			int cnt = 0;
			while (cnt < T) {

				if (lg - 1 > 0 && a[--lg] == 1) {
					cnt++;
				}
				if (ld + 1 < a.length && cnt < T && (a[ld++] == 1)) {
					cnt++;
				}
			}
			int dist = ld - lg;
			if (dist  < minSoFar) {
				minSoFar = dist;
				r.strt = lg;
				r.end = ld;
			}
		}
		return r;
	}
}
