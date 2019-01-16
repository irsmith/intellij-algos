package TODO;


import java.util.Arrays;

public class BinSearch3 {
    static int T = 3;
    static int a[] = {-1,0,1,3,11,55};

    public static void main(String args[]) {

        Arrays.sort(a);
        System.out.println(iterative(a, T));
        System.out.println(rec(a, T, 0 , a.length));


    }

    //assume all unique and sorted
// return -1 if not found
    static int iterative(int arr[], int T) {
        int lo = 0;
        int hi = arr.length;
        while(hi > lo) {
            int mid = lo + (hi-lo)/2;

            if (arr[mid] == T) return mid;
            //if T < arr[mid] search left
            // else search right
            if (T < arr[mid]) {
                hi = mid -1;
            }  else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    static int rec(int arr[], int T, int lo, int hi) {
        int mid = lo + (hi-lo)/2;
        if (arr[mid] == T) return mid;
        if (T < arr[mid]) {
            return rec(arr, T, lo, mid-1);
        }  else {
            return rec(arr, T, mid+1, hi);
        }

    }
}


