package recursion;

/**
 * Created by issmith1 on 3/30/16.
 */
public class Permute {


    public static void main(String[] args) {
        char[] a = new char[]{'a','b','c','d'};

        perm(a, 0);  //start at zero, swap 0w0, 0w1,0w2,0w3 recurse on zero+1
        System.out.println("--------");

        permChunks("", new String(a));
    }

    private static void permChunks(String s, String a) {
        // accumulate answer in s. Split a into 2 chunks
        if (a.length() == 1) {
            System.out.println(s+a);
        } else {
            for (int i = 0;i<a.length();i++) {
                permChunks(s+a.charAt(i),
                        a.substring(0, i) + a.substring(i+1));
            }
        }
    }

    private static void perm(char[] a, int start) {

        //System.out.format("start:%d  %n",start);

        if (start == a.length -1) {
            System.out.println(a);
            flush();
        } else {
            for (int i=start;i < a.length;i++ ) {
                swap(a, i, start);
                perm(a, start+1);
                swap(a, i, start);
            }
        }
    }

    private static void flush() {
        System.out.flush();
        System.err.flush();
    }

    private static void indent(int depth) {
        for (int i = 0; i < depth; i++) System.out.print(" ");
    }

    private static void swap(char[] a, int lo, int hi) {
        char tmp = a[lo];
        a[lo]=a[hi];
        a[hi] = tmp;
    }
}
