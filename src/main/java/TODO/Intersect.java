package TODO;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by issmith1 on 8/17/17.
 */
public class Intersect {
    public static void main(String[] args) {
        int a[] = {3,3,3,3,3,3};
        int b[] = {4,4,4,4,4,4,4,4,4,4,3};
        System.out.println(f(a,b));
    }

    static List<Integer> f(int[] a, int[] b) {

        List<Integer> rv = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i =0; i<a.length; i++) {
            set.add(a[i]);
        }
        for (int i =0; i<b.length; i++) {
            if (set.contains(b[i])) {
                rv.add(b[i]);
            }
        }
        return rv;
    }
}
