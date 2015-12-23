/**
 * Created by irene on 12/21/15.
 */

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class TwoStringsHackerRank {

    static boolean f(String A, String B) {
        // is char in A?
        boolean a[] = new boolean[26];
        for (int i=0;i<A.length();i++) {
            a[A.charAt(i) - 'a'] = true;
        }

        System.out.println(Arrays.asList(a));
        for (int i=0;i<B.length();i++) {
            char c = B.charAt(i);
            if (a[c - 'a']) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        boolean rv = f("hello","world");

        System.out.format("%s %n", (rv? "YES":"NO"));

        Scanner s = new Scanner (System.in);
        int N = s.nextInt();

        for (int i=0;i<N;i++) {
            String A=s.nextLine();
            String B = s.nextLine();
             rv = f(A, B);
            System.out.format("%s %n", (rv? "YES":"NO"));

        }
    }
}
