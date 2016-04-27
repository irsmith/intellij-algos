package sort;

import java.util.Scanner;

/**
 * Created by irene on 2/20/16.
 */
/*
You are given an array of size N . You need to answer Q queries. Each Query contains 1 number x.
For each query, you need to add x to each element of the array and then report the sum of absolute values in the array.

Note : Changes to the array are permanent. See Sample for more clarification.



3
-1 2 -3
3
1 -2 3
*/
public class PlayWNumbersHackerRank {

        public static void main(String[] args) {
            String x = "\n" +
                    "3\n" +
                    "-1 2 -3\n" +
                    "3\n" +
                    "1 -2 3";
            Scanner s = new Scanner(x);//System.in);
            int N = s.nextInt();
            s.nextLine();
            int a[] = new int[N];
            for (int i=0;i< N;i++ ){
                a[i] = s.nextInt();
            }
            s.nextLine();
            int Q = s.nextInt();
            s.nextLine();
            for (int i=0;i< Q;i++ ) {
                int q = s.nextInt();

                int res = 0;
                for (int j=0;j< N;j++ ){
                    a[j] += q;
                    res += Math.abs(a[j]);
                }
                System.out.println(res+" ");
                //System.out.println(Arrays.toString(a));
            }
        }
    }
/*
 BufferedReader br = new BufferedReader("c:/test.txt");
         while ((thisLine = br.readLine()) != null) {
            System.out.println(thisLine);
         }
 */