package dp;

/**
 * Created by issmith1 on 5/18/16.
 *         // count number ways to make change

 */
public class CountMakeChange {

    //static int a[] = {3,5,1};  NO static is hard to test

    public static void main(String[] args) {

        int a[] = {3,5,1};
        int a_empty[] = {};
        int a_one[] = {3};
        int a2[] = {3,1};

        System.out.println(f(a2, 0, 7));
    }

    //http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
    //
    // for a given subarry in range :i (suffix), nbr ways = f(i) + f(i+1)
    // where if subarray length is 0 then return 0 and if subarray len is 1
    // return 1.
    private static int f(int[] a, int i, int T) {
         if (i==a.length) {
             return 0;
         }
          else if (T == 0) {
             return 1;
         } else if (T < 0) {
              return 0;
         }
         return f(a, i, T-a[i]) + f(a, i+1, T);

    }
}
