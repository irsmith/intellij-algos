package array;

import java.util.*;

/**
    time O(m+n) where m is smaller length
    space O(2m)

     https://stackoverflow.com/questions/3230122/big-oh-vs-big-theta
     Big Oh: T(n) grows asymptotically no faster than O(m+n)
     Big Theta: T(n) grows asymptotically AS FAST AS than O(m+n)

 */
public class Intersection2Arrays {
    static int a[] = {3,4,9,1};

    static int b[] = {1,3,11};

    public static void main(String[] args) {

        if (b.length < a.length) {
            System.out.println(f(a,b));
        } else {
            System.out.println(f(b,a));
        }

    }

    private static List<Integer> f(int[] a, int[] b) {

        List<Integer> rv = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int n : a) {
            set.add(n);
        }
        for (int i=0;i<b.length; i++) {
            if (set.contains(b[i])) {
                rv.add(b[i]);
            }
        }
        return rv;


        }

}
