package array;

/**
 * Given "12345" return int 12345
 * From Sherry
 */
public class StringToInt {


    static String a = "12345";

    public static void main(String[] args) {

        System.out.println(f(a));


    }
    static long f(String a) {

        long v = 0;
        for (int i=a.length()-1; i>=0; i--) {

            int tmp = (int)a.charAt(i) - '0';
            long power = (long)Math.pow(10, i);

            v = (tmp * power) + v;

        }


        return v;
    }

}
