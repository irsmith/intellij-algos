package array;

import java.io.IOException;

public class BalancePoint {
	public static void main(String[] args) throws IOException {

		int[] _array = { 1, 2, 3, 2, 1 };
		int[] _array2 = { 1, -1, 2, 3, 1,1, 1 ,-1};

		int res = balancePoint(_array2);
		System.out.println(res);
	}

	static int acsLeft(int []a,int cur) {
		if (cur < 0)
			throw new RuntimeException();
		if (cur == 0)
			return 0;
		return a[cur - 1];

	}

	//return val of a at right idx
	static int descRight(int[] a, int cur) {
		if (cur >= a.length )
			throw new RuntimeException();
		if (cur == a.length - 1)
			return 0;
		return a[cur + 1];

	}

	static int balancePoint(int[] a) {
		if ((a.length < 1))
			return -1;
		int result = -1;
		int left = 0;
		for (int k = 0; k < a.length; k++) {
			left += a[k];
		}
		int rhs = 0;
		int Bk = a.length - 1;
		while (Bk >= 0) {
			int nxtRight = descRight(a, Bk);
			if ((left-a[Bk] - nxtRight) == (rhs + nxtRight)) {
				return Bk;
			} else {
				//remove from left and add to right 
				left -= nxtRight;
				rhs += nxtRight;
			}
			Bk--;
		}
		return result;

	}
}
