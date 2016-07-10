package dp.coinMinium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by issmith1 on 5/4/16.
 */
public class MinCoins {
    public static void main(String[] args) {
        Integer [] demon = {1,3,5};
        int T = 7;
        Arrays.sort(demon);
        System.out.println(f(demon, 0, T));
    }

    private static int f(Integer[] demon, int start, int T) {
        int min = Integer.MAX_VALUE;

        if (T == 0) {
            return 1;
        } else if (T <=0) {
            return 0;
        }
        for (int i=start; i<demon.length;i++) {
            int sumWithithCoin = f(demon, start, T-demon[i]) + 1;
            int sumWithoutIthCoin = f(demon, start+1, T);
            min = Math.min(min, Math.min(sumWithithCoin,sumWithoutIthCoin));
        }


        return min;

    }

    /**
     *
     * aha!! when using a cache, three things:! init it, read it and update it
     * aha!  when alloc cache, we want it to hold N+1 things prob.
     */
    public static class CoinMinSetSize {
        static int ca[];

        static Set<Integer> set = new HashSet<Integer>();
        static {
            set.add(1);
            set.add(2);
            set.add(3);
        }


        static int minSet_iterative(Set<Integer> set, int i, int N) {
            // assert set has a one ?
            initCache(set,N);
            for (int k=1;k<=N;k++) {

                // find local min for all coins
                int candidate = 0;
                for (int c:set) {
                    if (k-c > 0) {
                       candidate = ca[k-c];
                    }
                }
                candidate++; //
                System.out.println("candidate:"+candidate);
                // find min at K
                ///int minatk = 1+ Math.min( Math.min(getCach(k-1), getCach(k-2)), getCach(k-3));


                // store min at K to cache

                ca[k]=candidate;

            }
            return ca[N];
        }

        private static void initCache(Set<Integer> set, int N) {
            ca = new int[N+1];
            ca[0]=0;
            for (int i:set) {
                ca[i]=1;
            }

        }
        public static void main(String[] args) {
            Integer set2[] = { 1, 5, 10, 25 };

            assertEquals(1, minSet_iterative(set, set.size(), 1));
            assertEquals(1, minSet_iterative(set, set.size(), 2));
            assertEquals(2, minSet_iterative(set, set.size(), 4));

            assertEquals(5, minSet_iterative(set, set.size(), 11));



        }
    }
}
