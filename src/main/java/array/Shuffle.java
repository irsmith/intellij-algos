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
        Integer a[] = {1, 2, 3, 4, 5};

        for (int k=0;k<10;k++) {
            System.out.println(Arrays.asList(shuffleInPlace(a)));
        }
    }
    public static Integer[] shuffleInPlace(Integer[] a){
        Random r = new Random();

        for (int i = a.length - 1; i > 0; i--) {
            int idx = r.nextInt(i+1); //gotcha for java
            swap(a, i, idx);
        }
        return a;
    }
    private static void swap(Integer[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
