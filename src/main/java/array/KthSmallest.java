package array;

import java.util.Arrays;

//    Find Kth smallest element in array (2 cases online and offline)
// for heap,
// find operation is order 1
// del and insert it order n
public class KthSmallest {


    public static void main(String[] args) {
        int a[] = { 4, 3, 9, 78, 24, 5, 0, 77 };

        pv(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));

    }

    private static void pv(int[] a, int i, int i1) {
        // choose a random index, lo at end of array hi and other end.
    }
}
