package dp;


public class LongestIncreasingSubsequence3 {

	public static void main(String[] args) {
		int[] a2 = {200, 201, 100, 101, -10, 102, -9, 103, -8, -6, -5, 300, 301}; //7
        int[] a3 = {200, 201, 100, 101, -10, 102, -9, 103, -8, -6, -5}; //5

        int[] a = {300, 200, 201, 100, 101, 102 };

        int result = lis(a3);
        System.out.println (result);

	}

    private static int lis(int[] a) {

	    int max = Integer.MIN_VALUE;
	    int dp[] = new int[a.length];
	    dp[0]=1;

	    for (int i = 1; i<a.length;i++ ){

	        int val=a[i];
            int loccalmax = Integer.MIN_VALUE;

            for (int j=0;j<i; j++) {
                int candidate = 1;
	            if (a[j] < val) {
	                candidate = dp[j]+1;
                }
                if (loccalmax < candidate) loccalmax = candidate;
            }
	        dp[i]=loccalmax;
            if (loccalmax > max) max = loccalmax;
        }

	    return max;
    }




}