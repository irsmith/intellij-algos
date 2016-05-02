package dp;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by issmith1 on 4/30/16.
 *
 * naive solution O (N cubed)
 * any solution w abort at M-1
 * DP O(N squared)
 *
 *
 *
 0 0 0 0 0
 3 3 2 2 5  // subarr of length 1 ending at j
 6 5 4 0 0
 1 0 2 0 0
 3 5 0 0 0   // should be  3 1
 1 0 0 0 0   // should be 5

 */
public class MaxModulusHackrank2 {

    static Integer a[] = {3, 3, 9, 9, 5};
    static int M = 7;
    //static Map<Point, Integer> DP  = new HashMap<>();
    static int[][] DP = new int[a.length+1][a.length+1];

    public static void main(String[] args) {
        dp();
//        int answ = naive();
//        System.out.println(answ);

        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[i].length; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
    }

    // naive is n cubed --
    private static int naive() {

        List<List<Integer>> all = new ArrayList<>();  //n sqared of these
        List<List<Integer>> all2 = new ArrayList<>();  //n sqared of these

        int maxendingati = Integer.MIN_VALUE;
        int inmax = Integer.MIN_VALUE;

        for (int i=0;i<a.length;i++) {

            for (int j=0;j<=i; j++){

                // inner loop!  use copy range, or..... another k loop BUT cannot sum if use copy
                Integer[] inlinst = Arrays.copyOfRange(a,j, i); // cost is O(n)
                all2.add(Arrays.asList(inlinst));

                int sum = 0;
                List<Integer> lista = new ArrayList<>();
                all.add(lista);
                for (int k=j; k<=i; k++) {
                    sum += a[k];
                    lista.add(a[k]);
                }
                int locMax = sum % M;
                inmax = Math.max(inmax,locMax);
                System.out.println(String.format("list:%s,locMax:%d inmax:%d",  Arrays.asList(lista),locMax, inmax));

            }
            maxendingati = Math.max(maxendingati, inmax);

        }
        return maxendingati;
    }

    // A subarr is uniquely identifed by ending at and its length
    // DP rows is length of subarray -- should be 15 rows
    // DP col is "ending at"
    private static void dp() {
        int truncate = 0;
        for (int subaLength = 1; subaLength <= a.length; subaLength++) {
            for (int subArrStart = 0; subArrStart < a.length - truncate; subArrStart++) {
                if (subaLength == 1) {

                    DP[subaLength][subArrStart] = a[subArrStart] % M;

                } else {

//                    System.err.println(String.format("DP[subaLength][subArrStart] %d,%d", subaLength, subArrStart));
                    DP[subaLength][subArrStart] =  ( DP[subaLength-1][subArrStart] + DP[1][subArrStart+subaLength-1]   ) % M;
                }
            }

            truncate++;

        }
    }
}
