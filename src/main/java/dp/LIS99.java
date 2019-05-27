package dp;


public class LIS99 {

    /**
     Big O of n-sqared solution
     edge case, a is empty ignore for now
     Using Binary search we can get O(nlog-n)
     https://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn
     */
    static int osq(){
        int dp[] = new int[val.length]; //  length of the subarray ending at i
        dp[0]=1;
        int globMax = 0;
        for (int i=0 ; i<val.length; i++) {
            int localMax = 0;
            //  update dp[i] by
            //  by scan left hand side candidates for localmax of lengths
            //  dp[j] is a candidate only if val[i] > v[j]
            for (int j=0;j<i;j++) {
                if (val[i] > val[j]) {
                    // we have a candidate
                    localMax = dp[j]+1;
                    localMax = Math.max(globMax, localMax);

                }
                dp[i] = localMax;
            }
            globMax = Math.max(globMax, localMax);
        }

    return globMax;

}

    // o-squared solution
    static int val[] = {-3,1,-9,0,3,-1,5,6,-2};
    public static void main(String args[]) {

        System.out.println(osq());

    }


}
