package fizzbuzzEtc;

public class PrimesLessThanN {

	/**
	 * Mathematical theory: a math model based on axioms.  has a proof
	 * Axiom or postulate - its truth is self-evident
	 * THeory of Primae Facorization - each whole number can be factored into a unique set of prime numbers
	 *
	 * Top level requirement is defined by outer method.  Details are handled in helper function.  The top
	 * level code is readable to the top level requirement.
	 *
	 * good programming begins with software architecture and that involves divide and conquer. So making
	 * a stand-alone helper function that works for all input is a good first step.
	 * https://stackoverflow.com/questions/37077459/finding-prime-number-between-1-and-n
	 */
	public static void main(String[] args) {

		System.out.printf("negative number");
		prime(-100);
		prime(0);
		prime(1);
		prime(2);

		prime(100); // nominal

	}



	/**
	 * Print all prime numbers less than N
	 * A prime number is greater than one.
	 * Negative numbers are excluded. https://primes.utm.edu/notes/faq/negative_primes.html
     *
	 * ... code matches your contract "numbers between 1 and N". No implied short-cut starting at 2, but clarity that
	 * code is properly testing all numbers [1...N].
	 * https://stackoverflow.com/questions/37077459/finding-prime-number-between-1-and-n
	 *
	 * Scope is public.  Here we handle user interface stuff like new line.
	 * @param N
	 */
	public static void prime(int N) {
		System.out.println("Set of primes for N="+N);

		for (int i = 1; i <= N; i ++) {
			if (isPrime(i)) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}

	/*
	 * If candidate Factor is prime then all possible factors less than candidate will result in a remainder.
	 * Thus if no remainder for all i's, return True.
	 *
	 * 1. only need to consider i's that are odd numbers
	 * 2. max prime-factor is always less than N/2, or more precisely the square root of N
	 */
	private static boolean isPrime(int candidateFactor) {

		if (candidateFactor <= 1) return false;  //negative number, 0 and 1 are not considered
		if (candidateFactor == 2) return true;
		if (candidateFactor % 2 == 0) return false;
		for (int i = 3; i <= candidateFactor/2; i++) {
			if ((candidateFactor % i ) == 0) return false;
		}
		return true;
	}

}
