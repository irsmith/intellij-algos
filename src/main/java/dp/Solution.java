package dp;
import java.util.Scanner;

/**
 * Created by skupunit on 4/30/16.
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
 3 5 0 0 0  
 1 0 0 0 0  

 INPUT : run into intellij console, hit return, hit AppleD
 1
 5 7
 3 3 9 9 5
 OUTPUT
 6



 Bought test case:::
 1
 50 1804289384
 846930887 1681692778 1714636916 1957747794 424238336 719885387 1649760493 596516650 1189641422 1025202363 1350490028 783368691 1102520060 2044897764 1967513927 1365180541 1540383427 304089173 1303455737 35005212 521595369 294702568 1726956430 336465783 861021531 278722863 233665124 2145174068 468703136 1101513930 1801979803 1315634023 635723059 1369133070 1125898168 1059961394 2089018457 628175012 1656478043 1131176230 1653377374 859484422 1914544920 608413785 756898538 1734575199 1973594325 149798316 2038664371 1129566414

 1804289384  mod
 1802192837  answ


 */
public class Solution {

    static Integer a[] =null;
    static int M;
    static int N;
    static long[][] DP = null;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for( int tt = 0;tt<T;tt++)   {
            s.nextLine();
            N=s.nextInt();
            M=s.nextInt();
            a= new Integer[N];
            DP = new long[a.length + 1][a.length + 1];

            s.nextLine();
            int sumOverN = 0;
            for (int c = 0; c < N; c++) {
                a[c] = s.nextInt() % M;
                if (a[c] > M) {
                    System.out.format("lllleeess a[c]:%d c:%d",a[c],c);
                    System.exit(1);
                }
                sumOverN = (sumOverN + a[c]) % M;
                if (sumOverN > M) {
                    System.out.format("summmmm sumOverN:%d ",sumOverN);
                    System.exit(1);
                }

            }
            //2≤Sum of N over all test cases≤500000
            //System.out.println(sumOverN);


            System.out.println(dp());
        }

    }

    // A subarr is uniquely identifed by ending at and its length
    // DP rows is length of subarray -- should be 15 rows
    // DP col is "ending at"
    private static long dp() {
        long max = Integer.MIN_VALUE;
        int truncate = 0;
        for (int subaLength = 1; subaLength <= a.length; subaLength++) {
            for (int subArrStart = 0; subArrStart < a.length - truncate; subArrStart++) {
                if (subaLength == 1) {

                    DP[subaLength][subArrStart] = a[subArrStart] % M;
                    if (DP[subaLength][subArrStart] < 0) {System.out.println("less:base case");}

                } else {
                    DP[subaLength][subArrStart] =  ( DP[subaLength-1][subArrStart] + DP[1][subArrStart+subaLength-1]   ) % M;
                    if (DP[subaLength][subArrStart] < 0) {
                        System.out.println("less: 3");
                    }

                }
                //if (DP[subaLength][subArrStart] == M-1) return DP[subaLength][subArrStart]; 
                max = Math.max(max, DP[subaLength][subArrStart]);
            }

            truncate++;

        }
        return max;
    }
}

/*
 https://www.hackerrank.com/challenges/maximise-sum
*/