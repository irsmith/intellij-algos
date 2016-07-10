package dp.coinsNbrWays;
import static org.junit.Assert.assertEquals;

public class CoinsWaysMakeChange {

	static Integer set[] = {1,5,10,25};
	static int f(int t) {
		if (t < 0) return 0;
		if (t == 0) return 1;
		
		int ways=0;
		for (int i=0;i<set.length;i++){
			ways += f(t - set[i]);
		}
        return ways;
	}
	public static void main(String[] args) {

		assertEquals(1, f(1));
		assertEquals(1, f(2));
		assertEquals(1, f(3));
		assertEquals(1, f(4));

		assertEquals(2, f(5)); // ways to make 4 + 1
		assertEquals(2, f(6)); // ways to make 4 + 1

		
	}
}
