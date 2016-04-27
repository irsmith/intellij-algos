package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by irene on 3/13/16.
 */
public class GreedyTwoPointers {
    public  static final void main(String args[]) {
        Integer total=0;
        //int[] a = {3, 4, 5, 8, 9, 10, 22, 23, 24, 25, 26, 27};
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        int a[] = new int[N];
        for (int i=0;i<N;i++){
            a[i]=s.nextInt();
        }
        Arrays.sort(a);
        int i=0;
        while (i < a.length) {
            int j=i;
            while (j+1 < a.length && (a[j+1] - a[i] <= 4)) {
                j++;
            }
            total++;
            i=j+1;
        }
        System.out.println(total);
    }
}
