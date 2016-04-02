package array;


public class Fib2 {

	
	public static void main(String[] args) {
		assertEquals(0, fib(0) );
		assertEquals(1, fib(1) );

		assertEquals(21, fib(8) );


		//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, ...
	}

	

	private static int fib(int i) {
		if (i<=1) return i;
		
		return fib(i-1) + fib(i-2);
	}

	private static void assertEquals(int a, int b) {
		if (a != b) throw new RuntimeException();
	}

}
