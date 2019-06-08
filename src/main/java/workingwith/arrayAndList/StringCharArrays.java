package workingwith.arrayAndList;

public class StringCharArrays {
    /*
        /**
        Given a 32-bit signed integer, reverse digits of an integer.


        https://leetcode.com/problems/reverse-integer/
    t1: input: something that overflows -
        out: 0
        reason:

    t2: in:0 out:0

    t3: in: -43
        out: -34
        note: if we convert to string , handle sign char separeately

    Approach: int to string,string to char[], reverse char[] ,char[] to string,
    then string to int

    */


    /**
     *  convert int to string
     *  convert string to char[] in reverse
     *  convert char[] to String
     */
    static int f(int x) {
        boolean isNegative = x < 0;
        String xstr = null;
        x = Math.abs(x);

        int rv = 0;
        try {
            xstr = Integer.toString(x); // utility functions know how to create themselves
        } catch (Exception e) {
            return 0;
        }
        // create revers char array -- SWAP hi lo
        char[] revCharArr = new char[xstr.length()];
        for (int hi=xstr.length() - 1,lo=0; (hi >= lo) ;hi--, lo++){
            char tmp=xstr.charAt(lo);
            revCharArr[lo]=xstr.charAt(hi);
            revCharArr[hi] = tmp;
        }

        // convert string to int and return
        try {
            rv = Integer.parseInt(String.valueOf(revCharArr));
        } catch (Exception e) {
            rv = 0;
        }

        return isNegative ? (-1 * rv) : rv;
    }
    public static void main(String[] args) {

        int cases[] = {123,1,12, 1234567890, 0,1999999999, -123,Integer.MAX_VALUE,-Integer.MAX_VALUE, Integer.MIN_VALUE, -Integer.MIN_VALUE};
        for (int i:cases) {
            System.out.println(f(i));
        }


    }
}
