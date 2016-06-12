package fizbuz;

/**
 * Created by irene on 6/11/16.
 */
public class Fizbuz {
    public static void main(String[] args) {

        for (int i = 3;i<100;i++) {
            System.out.println(i);
            if (i % 3 == 0) {
                System.out.print("fiz");
            }
            if (i % 5 == 0) {
                System.out.print("buz");
            }
            System.out.println();  // bug had it in wrong place
        }
    }
}
