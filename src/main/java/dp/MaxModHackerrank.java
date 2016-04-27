package dp;

import org.junit.Assert;

import java.util.HashMap;
import java.awt.Point;
import java.util.Map;
import java.util.Objects;

/**
 * Created by issmith1 on 4/27/16.
 */
public class MaxModHackerrank {

    static int a[] = {3,3,9,9,5};
    static int M = 7;
    static Map<Point, Integer> DP  = new HashMap<>();

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);
        Assert.assertTrue(p1.equals(p2));
        dp(0,a.length-1);
        System.out.println(f (0,a.length-1));
    }

    // fill up hash table
    private static void dp(int start, int end) {
        for (int i=start; i <= end; i++) {



                    int temp = DP.get(new Point())
                    DP.put(new Point(j,j), suffix);
                    int answ = (DP.get(new Point(i, j-1)) + suffix) % M;
                    DP.put(new Point(i,j), answ);
            }
        }
    }

    private static int f(int i, int j) {


        if (i==j) {
            int temp = a[i] % M;
            System.out.println(String.format("i %d j %d answ %d %n",i,j,temp));
            return temp;
        }
        int temp = Math.max( f(i, j-1) , f(j,j));
        System.out.println(String.format("-- " +
                "i %d j %d answ %d %n",i,j,temp));
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
            Key k = (Key)o;
            return (this.i==k.i) && (this.j == k.j);
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
