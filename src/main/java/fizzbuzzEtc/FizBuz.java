package fizzbuzzEtc;

public class FizBuz {

	/**
	 * print nbr 1 to 100.  If i mult of 3 print fiz, if i mult 5 print buz,
	 * if mult both print fizbuz else print i
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
             if (i%3==0) {
            	 System.out.print("fiz");
             }
             if (i%5==0) {
            	 System.out.print("buz");

             } else {
            	 System.out.format("%n%d%n",i);
             }
             System.out.println();
		}
	}

}
