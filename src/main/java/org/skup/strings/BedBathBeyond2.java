package org.skup.strings;
import com.sun.tools.javac.util.Assert;

import java.util.Set;
import java.util.HashSet;

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

        //0123456789012

//        System.out.println(f(dict, "BedBathBeyond", 0, 0));
        System.out.println(f(dict, "BedxBathBeyond", 0, 0));

    }

    private static boolean f(Set<String> dict, String word, int lo, int hi) {
        System.out.format("-->%d %d %n", lo, hi);

        if (hi >=word.length()) return true;
        if (lo > hi) {
            return false; // a word has at least one letter
        }


        String candidate=word.substring(lo,hi);
        System.out.format("--%s %d %d %n", candidate, lo, hi);
        if (dict.contains(candidate)) {
            lo = hi;
            return f(dict, word, lo, hi);
        }

        return f(dict, word, lo, hi+1);
    }


}
