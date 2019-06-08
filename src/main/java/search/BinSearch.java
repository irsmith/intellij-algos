package search;

public class BinSearch {

    //F (0) = 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
    public static void main(String args[]){
        int[] arr = { 88, 1, 1, 2, 3, 5, 8, 13, 21, 34 };


        System.out.println(binsearch(arr, 5));
        System.out.println(binsearch(arr, 34)); // 9
        System.out.println(binsearch(arr, 355)); // MAX

        System.out.println(binsearch(new int[]{88}, 88)); //0
        System.out.println(binsearch(new int[]{999}, 355)); // MAX
    }
    /**
     */
    static int binsearch(int[] arr,  int T){

        return bins(arr,0, arr.length-1, T);
    }

    // returns the index where T is found
    static int bins(int[] arr, int lo, int hi, int T) {
        if (lo > hi) return Integer.MAX_VALUE;

        int mid = lo + ((hi - lo) / 2);
        if (arr[mid] == T) return mid;
        if (T < arr[mid]) {
            return bins(arr, lo, mid-1, T);
        }
        else {
            return bins(arr, mid+1, hi, T);
        }
    }
//if (arr.length == 1) {
//        return (arr[lo]==T) ? lo:Integer.MAX_VALUE;
//    }



}


