package TODO;

public class Steps {

    //https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
    //minJumps(start, end) = Min ( minJumps(k, end) ) for all k reachable from start
    // assume we start at index 0.
    static int basecase[] = {9};  // if we're on 0 then it takes zero steps to reach end.

    // extra credit, can do later
    // When nothing is reachable from the given source base case if (arr[l] == 0) return Integer.MAX_VALUE;

    static int a[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};

    int a3[] = {};
    int a8[] = {9};

    static int a34  [] = {1,3,  5, 8, 9, 2, 6, 7, 6, 8, 9}; //irene data
    static int dp[] = new int[a.length];

    public static void main(String[] args) {
        // System.out.println( minHops(0, a.length-1));;  naieve
        for (int i = 1; i < a.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for (int i = 1; i < a.length; i++) {
            int stepsFromCur = a[i];
            for (int j=i+1;j <= j+stepsFromCur && j<a.length;j++) {

                dp[j] = Math.min(dp[j], dp[i]+1);
                System.out.printf("lo:hi %d:%d nbrSteps %d localMin:%d %n",i,i,stepsFromCur, dp[j]);

            }
        }
        System.out.println( dp[a.length-1]);
    }

    //naive recursive approach
    private static int minHops(int lo, int hi) {
        //base case takes first cell, thus the loop is from i+1
        if (lo == hi) return 0;

        int minAllReachable = Integer.MAX_VALUE;
        // for all steps reachable from lo, calculate #hops.  Returns min of all reachable.
        // Gotcha!  i=lo+1
        int numsteps=a[lo];
        // Gotcha!  i must be less than hi
        for (int i=lo+1; i <= hi && i <= lo+numsteps; i++) {  //all steps reachable from lo
            int hops = minHops(i,hi) + 1;
            minAllReachable = Math.min(minAllReachable, hops);
        }
        System.out.printf("lo:hi %d:%d nbrSteps %d overallMin:%d %n",lo,hi,numsteps, minAllReachable);
        return minAllReachable;
    }

}
