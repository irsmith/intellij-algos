package util;


public class NumberFun {
    public static long findNextSquare(long sq) {
        double rv = Math.sqrt(sq);
        double p = (rv + 1);
        return (long) (p*p);
    }

    public static void main(String[] args) {
        double result;
        boolean testResult;

        //t1 happy
         result = findNextSquare(144);
         testResult = false;
        if (result == 169) {
            testResult = true;
        }
        System.out.println(testResult);

        //t2 neg
         result = findNextSquare(133);
         testResult = false;
        if (result == -1) {
            testResult = false;
        }
        System.out.println(testResult);

    }
}
