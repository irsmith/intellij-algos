package recursion;

/**
 * Created by issmith1 on 3/30/16.
 */
public class Permute {


    public static void main(String[] args) {
        char[] a = new char[]{'a','b'};

        perm(a, 0, a.length-1, 0);
    }

    private static void perm(char[] a, int start, int end, int depth) {

        depth++;
        indent(depth);
        System.out.format("depth:%d start:%d end:%d %n",depth,start,end);
        flush();

        if (start == a.length -1) {
            // print since length is zero
            indent(depth);
            System.out.println(a);
            flush();
        } else {
            for (int i=start;i < a.length;i++ ) {
                swap(a, i, end);
                perm(a, i+1, end, depth);
                swap(a, i, start);
            }
        }
        depth--;
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
