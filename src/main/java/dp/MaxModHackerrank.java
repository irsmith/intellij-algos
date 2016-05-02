package dp;

import org.junit.Assert;

import java.awt.*;

/**
 * Created by issmith1 on 5/1/16.
 */


public class MaxModHackerrank {

    static int a[] = {3, 3, 9, 9, 5};
    static int M = 7;
    //static Map<Point, Integer> DP  = new HashMap<>();
    static int[][] DP = new int[a.length + 1][a.length + 1];

    public static void main(String[] args) {

        dp();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(DP[i + 1][j + 1] + " ");
            }
            System.out.println();
        }
        //System.out.println(f (0,a.length));

    }

    // fill up hash table
    private static void dp() {
        int truncate = 0;
        for (int subArrLen = 1; subArrLen < a.length + 1; subArrLen++) {
            for (int subArrStart = 1; subArrStart < a.length + 1 - truncate; subArrStart++) {
                if (subArrLen == 1) {

                    DP[subArrLen][subArrStart] = a[subArrStart - 1] % M;

                } else {

                    System.err.println(String.format("DP[subArrLen][subArrStart] %d,%d", subArrLen, subArrStart));
                    DP[subArrLen][subArrStart] = (DP[1][subArrStart + subArrLen - 1] + DP[subArrLen - 1][subArrStart]) % M;
                }
            }

            truncate++;

        }
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