package TODO;

import java.util.Arrays;

//https://codereview.stackexchange.com/questions/69299/rotating-an-array-by-position-n
public class RotateArray {

    // optimization1
    // make sure we don't do unneeded loops.
    //    int actualIteration = K;
    //    if (actualIteration >= A.length){
    //        actualIteration = actualIteration % A.length;
    //    }

    public static void main(String[] args) {

        int[] unOrderedArr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int rotationOrder = 3;

        int [] aswr =   new RotateArray().bubble(unOrderedArr, rotationOrder);
        System.out.println(Arrays.toString(aswr));

        aswr =   new RotateArray().swapAllSwapParts(unOrderedArr, rotationOrder);
        System.out.println(Arrays.toString(aswr));

        aswr =   new RotateArray().rotateWithOffet(unOrderedArr, rotationOrder);
        System.out.println(Arrays.toString(aswr));




    }

    // alternative 3 - swap whole thing then swap each section
    int[] swapAllSwapParts(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("The array must be non-null and the order must be non-negative");
        }
        order = order % arr.length;

        if (order == 0) return arr;

        reverseLoHi(arr, 0, arr.length -1);
        reverseLoHi(arr, 0, order-1);
        reverseLoHi(arr,order, arr.length-1);

        return arr;
    }

    //reverse portion or array from lo to hi inclusive
    private void reverseLoHi(int[] a, int lo, int hi) {
        while (hi > lo) {
            int temp = a[lo];
            a[lo] = a[hi];
            a[hi] = temp;
            lo++;
            hi--;
        }

    }

    // alternative 1 -- bubble
    // requires no storage, but O(order * N)
    int[] bubble(final int[] arr, final int order) {

        for (int k = 0; k<order; k++) {
            int temp = arr[arr.length-1];
            for (int i = arr.length - 1;i > 0; i--) {
                arr[i] = arr[i-1];
            }
            arr[0] = temp;

        }
        return  arr;
    }

    // alternative 2 -- destination offset rolls over via module
    // Space complexity, O(N)
    // time, O(N)
    int[] rotateWithOffet(final int[] unOrderedArr, final int orderToRotate) {
        final int length = unOrderedArr.length;
        final int[] rotated = new int[length];
        for (int i = 0; i < length; i++) {
            rotated[(i + orderToRotate) % length] = unOrderedArr[i];
        }
        return rotated;
    }

}

