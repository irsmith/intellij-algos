package june26JayInterviewPrep;

import java.util.Arrays;

public class ArrIndexingOnePointer {

	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(a));
		for (int i = a.length - 2; i > 0; i--) {
			System.out.format(" cur i:%d, bef %d, after %d %n", i, a[i - 1],
					a[i + 1]);
		}
		System.out.println("last i (inside loop) is 1:");

		System.out.println(Arrays.toString(a));
		int i = a.length - 2;
		while (i > 0) {
			System.out.format(" cur i:%d, bef %d, after %d %n", i, a[i - 1],
					a[i + 1]);
			i--;
		}
		System.out.println("last i (exited loop). Oops this is one off :" + i);

		System.out.println("when using whiles, dont forget to clear your i's"		+ Arrays.toString(a));
		// increment at TOP
		i = a.length - 1; //starts one higher
		while (i > 1) { //ends one higher?
			i--;
			System.out.format(" cur i:%d, bef %d, after %d %n", i, a[i - 1],
					a[i + 1]);
		}
		System.out.format("last i upon exited loop is now cur:" + i);

	}
}
