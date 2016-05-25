package array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by issmith1 on 5/21/16.
 */
public class Shuffle {
    public static void main(String[] args) {
        // equally likely
        Random r = new Random();
        Integer a[] = {0, 1, 2, 3, 4, 5};

        for (int i = a.length - 1; i > 0; i--) {
            int idx = r.nextInt(i);
            swap(a, i, idx);
        }
        System.out.println(Arrays.asList(a));
    }

    private static void swap(Integer[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
