package array;

import java.util.Arrays;

/**
 * Iterative is usually bottom up and recursive top down
 */
public class MergeIterative {
    public static void main(String[] args) {
        int a[] = {1,2, 6, 8, 9, 12, 13};

        int test[] = {0, 2, 4, 6, 10, 12};
        System.out.println(Arrays.toString(        merge(test, a)));


    }

    private static int[] merge(int[] a, int[] b) {
        int m[] = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < m.length; k++) {
            if (i == a.length) {
                m[k] = b[j++];
            } else if (j == b.length) {
                m[k] = a[i++];
            } else if (a[i] <= b[j]) {
                //mv a to m
                m[k] = a[i++];
            } else {
                //mv b to m
                m[k] = b[j++];
            }
        }
        return m;
    }

}
