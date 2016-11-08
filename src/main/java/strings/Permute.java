package strings;

import java.util.Arrays;

public class Permute {
    public static void main(String[] args) {
        f2_top("c");

        f2_top("bc");
        f2_top("abc");

    }

    private static void f2_top(String bc) {
         f2(bc.toCharArray(), 0, bc.length()-1);
    }



    private static void f2(char[] a, int lo, int hi) {
        if (lo == hi) {
            print(a);
        }
        for (int i = 0; i < hi; i++) {
            swap(a, 0, hi-1);
            f2(a, lo+1, hi);
            swap(a, 0, hi-1);

        }
    }

    private static void print(char[] a) {
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i] + " ");
        }

    }

    static void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }






    private static void f(String prefix, String remain) {
        if (remain.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < remain.length(); i++) {
                f(prefix + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1, remain.length()));
            }
        }

    }

}
