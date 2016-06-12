package dp;

/**
 * Created by irene on 4/23/16.
 * http://stackoverflow.com/questions/18659792/circular-arraylist-extending-arraylist
 */
public class FibMIT_siz2 {
    static Integer[] cach =  null;

    public static void main(String[] args) {
        int n = 10;
        cach = new Integer[n+1];
        System.out.println(rec_memo2(n));
    }

    private static int rec_memo2(int n) {

        if (n<2){
            cach[n] = n;
            return n;
        }

        int cur= rec_memo2(n-2) + rec_memo2(n-1);
        cach[0] = cach[1];
        cach[1] = cur;
        return cur;
    }

}
