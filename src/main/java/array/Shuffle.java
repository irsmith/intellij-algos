package array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by issmith1 on 5/21/16.
 */
public class Shuffle {//e the Fisher–Yates shuffle:
    //http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array

    public static void main(String[] args) {
        // equally likely
        int a[] = {0, 1, 2, 3, 4, 5};


        System.out.println(Arrays.asList(shuffleInPlace(a)));
    }
    public static int[] shuffleInPlace(int[] a){
        Random r = new Random();

        for (int i = a.length - 1; i > 0; i--) {
            int idx = r.nextInt(i);
            swap(a, i, idx);
        }
        return a;
    }
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
