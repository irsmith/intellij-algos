package dp;

/**
 * Created by irene on 4/23/16.
 * http://stackoverflow.com/questions/18659792/circular-arraylist-extending-arraylist
 */
public class FibMIT_siz2 {
    static Integer[] cach =  null;

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,
    //0  1  2  3  4  5  6   7   8   9  10  11
    public static void main(String[] args) {
        int n = 10;
        cach = new Integer[2];
        System.out.println(rec_memo2(n));
        System.out.println(iterative_memo2(n));

    }

    private static Integer iterative_memo2(int n) {
        Integer dp[] = new Integer[n]; // or n+1??
        for (int i = 0;i<n;i++) {
            if (i <= 2) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];

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
