package TODO;


public class BitcoinProfit {

    static int T = 3;
    static int a[] = {9,0,1,3,11,55,12};

    public static void main(String args[]) {

        System.out.println(profit());

    }

    /** return max profit (not index */
    static int profit() {
        int lo = 0; //minimize this at each step
        //today's price is a[i]
        int profit = 0;
        for(int i=0;i < a.length;i++) {
            // update minimum if its lower than previous minimum
            if (a[i] < lo) {
                lo = a[i];
            }
            // update profit if its higher than previous profit
            if ( a[i] - lo > profit) {
                profit = a[i] - lo;
            }
        }
        return profit;
    }

}
