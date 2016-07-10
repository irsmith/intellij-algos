package dp.maxSubarray;

/**
 * Created by irene on 6/15/16.
 */
public class MaxSubArrAnsw {

    /*
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
       !! ask clarifying q!  only interesting if neg integers

       We have global and local max.
       Looking to your left you have a global max established. You also know the local max.
       Consider cur.  You can add cur to local array, or go it alone.  If local array is suffering from a
       negative number then cur going alone would be the new local max.  ... BUT this is confusing you say
       because adding cur to local max would increase local array value.  Sure but what if total array size
       ended, that is, if cur was last element in a?
     */
    public static void main(String[] args) {

        int a[] = {-2,1,-3,4,-1,2,1,-5,-4};
        f(a);
    }

    private static void f(int[] a) {

        int dp[] = new int[a.length];
        dp[0] = a[0];

        int maxOverall = dp[0];
        int begin = 0;
        int end = 0;

        for (int i=1;i<a.length;i++) {
            // candidate is a[i];
            // localMax is dp[i];
            int newBegin = begin;
            int newEnd = end;

            // Counterintuitive for me. If a[i] is BETTER then previous list start NEW list!
            if (dp[i-1] + a[i] < a[i]) {
                // our candidate alone beats localmax,  make a new list consisting of candidate)  see NOTE
                dp[i] = a[i];
                newBegin = i;
                newEnd = i;
            } else {
                //  candidate cannot stand on its own. Only choice is to add. Might degrade previous!
                dp[i] = dp[i-1] + a[i];
                newEnd = i;
            }

            if (maxOverall < dp[i]) {
                begin = newBegin;
                end = newEnd;
            }
        }
        System.out.format("begin: %d, End:%d",begin,end);
    }
}
