package linkedList;

// 0,1,
public class Fib {
     int G = 12;
     int N = 2;
     int[] dp = new int[N];

    void exec() {
      dp[0]=0;
      dp[1] = 1;
      System.out.print(dp[0]+ " ");
      System.out.print(dp[1]+ " ");

      for (int i=2;i<G;i++) {
        int nxt = dp[0]+dp[1];
        System.out.print(nxt+ " ");

        dp[0]=dp[1];
        dp[1] = nxt;
      }
    }

    public static void main(String args[]){

         Fib fib = new Fib();
         fib.exec();


    }
}
