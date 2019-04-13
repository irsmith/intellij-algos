package sort;


// todo debug sedgiwick 273
public class MergeSort {

    int[] aux = null;

    // merge 2 sorted lists a[lo]:a[mid] and a[mid+1]:a[lo]
    // take the original data from aux but mutate a[lo]:a[hi]
    void merge2lists(int a[], int lo,int mid,int hi) {
        // list1 is lo to mid
        // list2 is mid+1 to hi
        int i = lo;  // i walks from lo to mid
        int j = mid+1;  // j walks fwd from mid+1 to hi
        for (int k=lo; k<hi + 1; k++ ){
            if (i > mid) {
                //a[k++] = aux[j++];  //NO k is incremented by for loop
                a[k] = aux[j++];  //NO k is incremented by for loop

            } else if (j>hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            }  else {
                a[k] = aux[j++];
            }
        }
    }

    void _mergesort(int a[], int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int mid = lo + ((hi-lo)/2);
        _mergesort(a, lo, mid);
        _mergesort(a, mid+1,hi);
        merge2lists(a,lo,mid,hi);

    }
    void mergesort(int a[]) {
        aux = new int[a.length];
        for (int i=0;i<a.length;i++) {
            aux[i]=a[i]; // sort within a, aux holds orig data
        }
        _mergesort(a, 0, a.length);
    }

    public static void main(String args[]){

        MergeSort m = new MergeSort();
        int[] a = {4,6,2,1,0,5,8};

        m.mergesort(a);
        for (int i = 0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }

    }
}
