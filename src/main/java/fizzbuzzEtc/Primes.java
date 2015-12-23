package fizzbuzzEtc;

public class Primes {

	public static void main(String[] args) {
		System.out.println(3%4);
		prime(100);
	}

	/*
	 * O(n squared)
	 * 1. only odd numbers
	 * 2. only up to square root of N
	 */
	private static void prime(int N) {


		for (int i = 3; i <= N; i += 2) {
			boolean isPrime = true;
			for (int factor = 3; factor < Math.sqrt(i); factor++) {
				//System.out.format("test factor %d with i %d %n", factor,i);
				if (i % factor == 0) {
					isPrime=false;
					break;
				}
			}
			if (isPrime) System.out.println(i);
		}

	}

}
