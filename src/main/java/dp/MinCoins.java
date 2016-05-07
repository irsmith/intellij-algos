package dp;

import java.util.Arrays;

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
}
