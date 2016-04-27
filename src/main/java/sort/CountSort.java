package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by irene on 2/15/16.
 */
public class CountSort {

    public static void main(String[] args) {
        int input[] = {3,3,0,0,0};

        int [] res = countSort(input);
        System.out.println("end res"+Arrays.toString(res));

    }

    private static int[] countSort(int[] arr) {
        int aux[]  = new int[arr.length];
        int output[]  = new int[arr.length];

        // put count into aux
        for (int i=0;i<arr.length;i++) {
            aux[arr[i]]++;
        }
       // System.out.println(Arrays.toString(aux));

        //System.out.println(Arrays.toString(list.toArray()));
        // cumulative count -- find largest index of each group
        for (int i=1;i<arr.length;i++) {
            aux[i] += aux[i-1];
        }
        System.out.println(Arrays.toString(aux));
        int j=0;
        for (int i=0;i<arr.length;i++) {
            while (j<aux[i]) {
                output[j++]=i;
                System.out.println(Arrays.toString(output));

            }
        }

        return output;
    }
}
