package org.skup.strings;
import com.sun.tools.javac.util.Assert;
import com.sun.tools.javac.util.StringUtils;

import java.util.Set;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;

public class BedBathBeyond2 {

    /*
     given dicitonary of words and a string, can you split string such
     that all words are in dict?
     */
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        for (String w: new String[]
                { "apple", "banana", "cactus", "fig", "guava", "pear", "tomato", "Bed", "Bath", "Beyond" }) {
            dict.add(w );
        }

        assertTrue(f2(dict, "", "BedBathBeyond"));
        org.junit.Assert.assertFalse(f2(dict, "","BedxBathBeyond"));

        assertTrue(f2(dict, "","BedBathBeyond"));
        org.junit.Assert.assertFalse(f2(dict, "","BedxBathBeyond"));
                                           // 0123456789 123
    }

    private static boolean f2(Set<String> dict, String cand, String r) {

        if (r.isEmpty()) {
            return (dict.contains(cand)) ? true : false;
        } else {
            if (dict.contains(cand)) {
                return f2(dict, "", r);

            } else {
                return f2(dict, cand+r.substring(0,1),
                        (r.length()==1)? "": r.substring(1));
            }
        }

    }

    /**
     * much better do in place w pointers. Not tearing up strings, can easily handle corner cases.
     * @param dict
     * @param word
     * @param lo
     * @param hi
     * @return
     */
    private static boolean f3(Set<String> dict, String word, int lo, int hi) {

        if (hi >=word.length()) return true;
        if (lo > hi) {
            return false; // a word has at least one letter
        }


        String candidate=word.substring(lo,hi);
        System.out.format("candidate:%s lo:%d hi:%d %n",candidate, lo, hi);
        if (dict.contains(candidate)) {
            lo = hi;
            return f3(dict, word, lo, hi);
        }

        return f3(dict, word, lo, hi+1);
    }


}
