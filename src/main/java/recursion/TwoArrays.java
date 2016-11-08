package recursion;

import java.io.*;
import java.util.*;

/*
2
3 10
2 1 3
7 8 9
4 5
1 2 2 1
3 3 3 4

You are given two integer arrays, A and B, each containing N integers. The size of the array is less than or equal to 1000. You are free to permute the order of the elements in the arrays.

Now here's the real question: Is there an permutation A', B' possible of A and B, such that, A'i+B'i ≥ K for all i, where A'i denotes the ith element in the array A' and B'i denotes ith element in the array B'.


Input Format
The first line contains an integer, T, the number of test-cases. T test cases follow. Each test case has the following format:

The first line contains two integers, N and K. The second line contains N space separated integers, denoting array A. The third line describes array B in a same format.

Output Format
For each test case, if such an arrangement exists, output "YES", otherwise "NO" (without quotes).


Constraints
the one of the arrangements, 3 2 1 and 7 8 9 has each pair of elements (3+7, 2 + 8 and 9 + 1) summing upto 10 and hence the answer is "YES".

The second input has array B with three 3s. So, we need at least three numbers in A that are greater than 1.
As this is not the case, the answer is "NO".
 */

public class TwoArrays {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        for (int t =0;t< T;t++) {
            int size = s.nextInt();
            int sum = s.nextInt();
            s.nextLine();
            Integer a[] = new Integer[size];
            Integer b[] = new Integer[size];

            for (int i=0;i<size;i++) {
                a[i] = s.nextInt();
            }
            s.nextLine();
            for (int i=0;i<size;i++) {
                b[i] = s.nextInt();
            }
            //System.out.format("T:%d, size:%d sum %d alen %d blen %d %n", T, size, sum, a.length, b.length);
            Arrays.sort(a);
            Arrays.sort(b, Collections.reverseOrder());
            String output = "YES";
            for (int j=0;j<size;j++) {
                if ((a[j] + b[j]) < sum) {
                    System.out.format("a %d b %d %n",a[j],b[j]);
                    output = "NO";
                    break;
                }
            }

            System.out.println(output);

        }


    }
}