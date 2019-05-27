package dp;

import java.util.Arrays;
import java.util.List;

//               Input: [−2,1,−3,4,−1,2,1,−5,4]     Output: 6 ([4,−1,2,1])
public class MaxSumSubarray {


    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        Integer dp[] = new Integer[arr.length];  // largest sum at i
        dp[0] = -2;
        long globMax = dp[0];
        for (int i=1;i<arr.length;i++) {

            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
            globMax = Math.max(globMax, dp[i]);

            System.out.println(Arrays.asList(dp)) ;
            System.out.printf("");
        }

        System.out.println(globMax);
    }
}
