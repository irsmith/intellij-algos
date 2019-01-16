package TODO;

public class Lis {

    static final int a[] = {5, 2, 13, 6 ,7,8,9};


    /* given int arr, return len of longest increasing subsequence.
       Note in this prob we are NOT required to return start/end indexes.

       at each i, keep track of highest value of the sequence using orig array itself, and seq length.

       assume all unique in a
     */


    public static void main(String[] args) {
        if (a.length <= 1) System.out.println("1");
        int lengthAti[] = new int[a.length];
        lengthAti[0] = 1;

        for (int i=1; i< a.length; i++) {
            int maxOverJ = 0;
            int locationMaxOverJ = 0;
            for (int j = 0; j< i; j++) {

                if (a[i] > a[j]) {
                    int candidateLocalMax = lengthAti[j] + 1;
                    if (candidateLocalMax > maxOverJ) {
                        maxOverJ = candidateLocalMax;
                        locationMaxOverJ = j;
                    }

                }
            }
            lengthAti[locationMaxOverJ] = maxOverJ;

        }


    }


}
