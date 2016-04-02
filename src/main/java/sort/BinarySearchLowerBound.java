package sort;

import java.util.Arrays;

/**
 * Created by irene on 2/21/16.
 */
public class BinarySearchLowerBound {

    public static void main(String[] args) {
        int key = -1;
        //LowerBound: find an element X in a sorted array of intergers such that
        // k <= x, where key K is given.
        int a[] = {-4,-2,0,2,7,8};
        Arrays.sort(a);
        int lo=0;
        int hi=a.length -1;
        int answ = binsearch_lowerBound(a, lo, hi, key);
        System.out.println(answ);
    }

    // find x such that x > the key
    // IOW find x such that x is closest to key but still greater than key
    private static int binsearch_lowerBound(int[] a, int lo, int hi, int key) {

        if (hi < lo) return Integer.MAX_VALUE;
        int mid = lo + ((hi - lo) / 2);
        int x = a[mid];
        if (x == key) {
            return x;
        } else if (x > key) {
            //search left
            return binsearch_lowerBound(a, lo, mid - 1, key);
        } else
            return binsearch_lowerBound(a, mid + 1, hi, key);


    }

}
