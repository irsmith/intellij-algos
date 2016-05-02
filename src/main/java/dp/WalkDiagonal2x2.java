package dp;

import org.junit.Assert;

import java.awt.*;

/**
 * Created by issmith1 on 5/1/16.
 */
public class WalkDiagonal2x2 {

    static int a[] = {3, 3, 9, 9, 5};
    static int M = 7;
    //static Map<Point, Integer> DP  = new HashMap<>();
    static int[][] DP = new int[a.length][a.length];

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Assert.assertTrue(p1.equals(p2));
        dp(0, a.length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
        //System.out.println(f (0,a.length));
    }

    // fill up hash table
    private static void dp(int start, int end) {
        int offset = 0;
        for (int i = start; i < end; i++) {
            for (int j = 0; j < end - offset; j++) {
                int col = j + offset;
                if (i == col) {
                    System.err.println(String.format("DP[i][col] %d,%d", i, col));

                    DP[i][col] = a[i] % M;

                } else {

                    System.err.println(String.format("DP[i][col] %d,%d", i, col));
                    DP[i][col] = Math.max(
                            (DP[i][col - 1] + (a[i] % M)) % M,
                            (DP[i + 1][col] + (a[i] % M)) % M
                    );
                }
            }

            offset++;

        }
    }


    private static int f(int i, int j) {


        if (i == j) {
            int temp = a[i] % M;
            System.out.println(String.format("i %d j %d answ %d %n", i, j, temp));
            return temp;
        }
        int temp = Math.max(f(i, j - 1), f(j, j));
        System.out.println(String.format("-- " +
                "i %d j %d answ %d %n", i, j, temp));
        return temp;
    }

    private static class Key {
        int i;
        int j;

        public Key(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            Key k = (Key) o;
            return (this.i == k.i) && (this.j == k.j);
        }

        @Override
        //http://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        public int hashCode() {
            //return Objects.hashCode((Integer)this.i, this.j);
            //return (this.i % 13) + (this.j % 13);
            int result = 17;
            result = 31 * result + i;
            result = 31 * result + j;
            return result;
        }
    }

}
