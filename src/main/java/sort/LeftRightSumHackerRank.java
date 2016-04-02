package sort;

/**
 * Created by irene on 2/17/16.
 */

import java.util.Arrays;
import java.util.Scanner;

/*
Output Format
For each test case print YES if there exists an element in the array, such that the sum of the elements on its left is equal to the sum of the elements on its right; otherwise print NO.
 */
public class LeftRightSumHackerRank {


    static void f(int[] a) {
        int tot = 0;
        for (int i=0;i<a.length;i++) {
            tot += a[i];
        }
        int lhs = 0;
        int rhs = tot;
        for (int i=0;i<a.length;i++) {
            rhs = (i == a.length-1)?  0 : rhs - a[i];
            if (lhs==rhs) {
                System.out.println("YES");
                return;
            }
            lhs =  lhs+ a[i];

        }
        System.out.println("NO");

    }


    public static void main(String[] args) {
        String x = "2\n" +
                "3\n" +
                "1 2 3\n" +
                "4\n" +
                "1 2 3 3";
        Scanner s = new Scanner (System.in);
        int T = s.nextInt();

        System.out.println("T"+T);


        for  (int k=0;k<T;k++) {
            int N = s.nextInt();
            System.out.printf("N"+N);

            int[] a = new int[N];
            for(int i=0;i<N;i++){
                a[i] = s.nextInt();
            }
            System.out.println(Arrays.toString(a ));

            f(a);
        }

    }

}
