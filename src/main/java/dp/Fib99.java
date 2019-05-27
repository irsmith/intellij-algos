package dp;

public class Fib99 {

        //F (0) = 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
        public static void main(String args[]){

            System.out.println(fib(0));
            System.out.println(fib(1));

            System.out.println(fib(5)); // should be 5
            System.out.println(fib(7)); // should be 13


        }

        static int fib(int n){
            if (n==0) return 0;
            if (n==1) return 1;
            int dp[] = {0, 1};

            int i=2;
            while (i <= n) {

                int cur = dp[0] + dp[1];
                dp[0] = dp[1];
                dp[1] = cur;
                i++;

            }
            return dp[1];

        }



}
