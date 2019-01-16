package strings;

/**
 * O(2R + N)
 * Alphabet size R is a given.
 * Data set size N is a given.
 * Iterate over cnt array of size R using p.
 * Iterate over data array using i.
 * Take care that i is incremented only when data is inserted, and that cnt[p] is used in the inner loop.
 */
public class CountSort {

    static char a[] = {'b','a','d','e','c','a','g','g','e','b','a','d'};
    static final int R=7; //alpha size

    static char result[] = new char[a.length];
    public static void main(String[] args) {

        f(a);
        printarr(a);
    }

    private static void f(char[] a) {
        int N = a.length;
        // O(N)  iterate over input N, map cnt to a "hashtable"
        int cnt[] = new int[R];
        for (int i = 0; i < N; i++) {
            cnt[a[i] - 'a'] += 1;
        }
        // cumulative
        int cur = 0;
        for (int i = 0; i < R; i++) {
            cnt[i] = cur + cnt[i];
            cur = cnt[i];
        }
        // We can decrement contents of cnt[]
        char c = 'a';
        int p = 0;
        int i = 0;
        while (i < a.length) {
            while (i< cnt[p]) {
                 a[i++] = c;
            }
            p++;
            c++;
        }
    }

    private static void printarr(char [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %c", arr[i]);
        }
        System.out.println();
    }
}
