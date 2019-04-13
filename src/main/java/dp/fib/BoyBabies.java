package dp.fib;

import java.util.Random;

/**
 *  start w one boy and one girl
 *  avg # boys in one birth is Probability of having a boy with 1 try (.5) OR with 2 tries (.25) or 3...
 *
 *  total $# babies = 1(.5) + 2(.25) + 3(.125) + 4(.655)
 *  #boys
 */

public class BoyBabies {
    int N = 5;  // precision - number times we half the probabiltiy

    double probabilities[] = new double[N];
    Random r = new Random();
    int G = 12;
    int[] dp = new int[N];

    BoyBabies() {
        probabilities[0]=0.5;
        for (int i=1;i<probabilities.length;i++){
            probabilities[i] = probabilities[i-1]*0.5;
        }
    }
    int genNumberExtraGirls() {
        int nbrGirls = 0;
        //generate 0 extra girls half of the time,
        //         1 extra girls .25 of the time...
        //         2 extra girls .125 of the time
        // pick a number 0 to 100.  if its 0-50 then 0 extra girls
        //  if 50to75  then 1 extra girl
        //  if 75 to (17+12.5) then 2 extra girl
        double slot = r.nextDouble();
        for (int i =N-1;i>=0;i--) {
            if (slot < probabilities[i]) return  i;
        }


        return nbrGirls;
    }

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


        BoyBabies fib = new BoyBabies();
        int tot = 0;
        int girls = 0;
        for (int i=0;i<fib.N;i++){

            System.out.print(fib.probabilities[i]+" ");
        }

        for (int i=0;i<100;i++){
            int nbr = fib.genNumberExtraGirls();

            System.out.print(nbr+" ");
            tot += nbr +1;
            girls += nbr;

        }
        System.out.print("\ntotal babies "+tot);
        System.out.print("\n xtra girl "+ girls);

        // fib.exec();

    }
}
