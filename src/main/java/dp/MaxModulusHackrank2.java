package dp;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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
    static int[][] DP = new int[a.length + 1][a.length + 1];

    int arr[] = null;// {4};
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for( int tt = 0;tt<T;tt++)   {
            String line = s.nextLine();
            int N=s.nextInt();
            int M=s.nextInt();
            Integer a[] = new Integer[N];
            s.nextLine();
            for (int c = 0; c < N; c++) {
                a[c] = s.nextInt();
            }
            dp();
        }

        _main(null);
    }
    // A subarr is uniquely identifed by ending at and its length
    // DP rows is length of subarray -- should be 15 rows
    // DP col is "ending at"
    private static void dp(Integer a[]) {
        int  max = 0;
        int truncate = 0;
        for (int subaLength = 1; subaLength <= a.length; subaLength++) {
            for (int subArrStart = 0; subArrStart < a.length - truncate; subArrStart++) {
                if (subaLength == 1) {

                    DP[subaLength][subArrStart] = a[subArrStart] % M;

                } else {

                    //  System.err.println(String.format("DP[subaLength][subArrStart] %d,%d", subaLength, subArrStart));
                    DP[subaLength][subArrStart] =  ( DP[subaLength-1][subArrStart] + DP[1][subArrStart+subaLength-1]   ) % M;
                }
                if (max == M -1 ) {
                    max = M-1;
                }
            }

            truncate++;

        }
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

                    //  System.err.println(String.format("DP[subaLength][subArrStart] %d,%d", subaLength, subArrStart));
                    DP[subaLength][subArrStart] =  ( DP[subaLength-1][subArrStart] + DP[1][subArrStart+subaLength-1]   ) % M;
                }
            }

            truncate++;

        }
    }

    public static void _main(String[] args) {
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


}

/*
 https://www.hackerrank.com/challenges/maximise-sum
 You are given an array of size N and another integer M. Your target is to find the maximum value of sum of subarray modulo M.

 Subarray is a continuous subset of array elements.

 Note that we need to find the maximum value of (Sum of Subarray)%M , where there are N×(N+1)/2
 N
 N
 1
 2
 possible subarrays.

 For a given array A[]
 A
 of size N
 N
 , subarray is a contiguous segment from i
 i
 to j
 j
 where 0≤i≤j≤N
 0
 i
 j
 N

 Input Format
 First line contains T , number of test cases to follow. Each test case consists of exactly 2 lines. First line of each test case contain 2 space separated integers N
 N
 and M
 M
 , size of the array and modulo value M.
 Second line contains N space separated integers representing the elements of the array.

 Output Format
 For every test case output the maximum value asked above in a newline.

 Constraints
 2≤N≤105
 2
 N
 10
 5

 1≤M≤1014
 1
 M
 10
 14

 1≤elements of the array≤1018
 1
 elements of the array
 10
 18

 2≤Sum of N over all test cases≤500000
 2
 Sum of N over all test cases
 500000

 Sample Input

 1
 5 7
 3 3 9 9 5
 Sample Output

 6
 Explanation

 Possible subarrays are
 {3},{3},{9},{9},{5}
 3
 3
 9
 9
 5

 {3,3},{3,9},{9,9},{9,5}
 3
 3
 3
 9
 9
 9
 9
 5

 {3,3,9},{3,9,9},{9,9,5}
 3
 3
 9
 3
 9
 9
 9
 9
 5

 {3,3,9,9},{3,3,9,9,5},{3,9,9,5}
 3
 3
 9
 9
 3
 3
 9
 9
 5
 3
 9
 9
 5

 their sums modulo 7
 7
 are

 3,3,2,2,5,6,5,4,0,1,0,2,3,1,5
 3
 3
 2
 2
 5
 6
 5
 4
 0
 1
 0
 2
 3
 1
 5
 respectively.
 Hence maximum possible sum taking Modulo 7
 7
 is 6
 6
 , and we can get 6
 6
 by adding first and second element of the array.

 Related Topics
 Binary Search
 Submissions: 7163
 Max Score: 65
 Difficulty: Moderate
 More
 Current Buffer (saved locally, editable)


 */