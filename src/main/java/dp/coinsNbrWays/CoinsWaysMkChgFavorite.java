
package dp.coinsNbrWays;

/**
 Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents)
 and pennies (1 cent). Write a code to calculate the number of ways of representing n cents.

 Input: 3		Output: 1 (1+1+1)
 Input: 10  	Output: 4 (10, 5+5, 5+1+1+1+1+1, 1+1+..+1+1)


 http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
 For example, if a currency system has the coins: {13, 8, 1}, the greedy solution would make
 change for 24 as {13, 8, 1, 1, 1}, but the true optimal solution is {8, 8, 8}
 DP would always work but for some denominations (like the US), even greedy would work!


 */
public class CoinsWaysMkChgFavorite {
    static int a2[] = {3,5,1};
    static int a_empty[] = {};
    static int a_one[] = {3};
    static int a[] = {25,10,5,1};
    static int memo[][];

    public static void main(String[] args) {

        System.out.println(f_helper(0, 10));
    }

    private static int f_helper(int i, int T) {
        memo = new int[a.length+1][T+1];
        for (int k=0;k<memo.length;k++) {
            for (int j=0;j<memo[k].length; j++) {
                memo[k][j] = -1;
            }
        }
        return f(i,T);
    }

    //http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
    //
    // for a given subarry in range :i (suffix), nbr ways = f(i) + f(i+1)
    // where if subarray length is 0 then return 0 and if subarray len is 1
    // return 1.
    private static int f(int i, int T) {
        if (T< 0) return 0;
        if (i > a.length) return 0;
        if (memo[i][T] != -1) {
            return memo[i][T];
        }
        if (i==a.length) {
            memo[i][T]=0;
            return 0;
        }
        else if (T == 0) {
            memo[i][T]=1;
            return 1;
        }
        return f(i, T-a[i]) + f(i+1, T);

    }
}

