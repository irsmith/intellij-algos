package strings;

// Determine if a given string is a palindrome. A palindrome is a string that is the same forwards as backwards,
// ignoring letter case, punctuation marks and word dividers. For example, “racecar” and “Amor, Roma” are
// palindromes, “abcd” is not. We limit the punctuation marks to ignore by the period, comma, question mark,
// exclamation point, apostrophe, colon, semi colon and hyphen.

import java.util.Arrays;
import java.util.List;

public class Palidrone {

    // assumes return true upon empty or ignored string
    public static void main(String[] args) {
        System.out.println(f(""));
        System.out.println(f("a"));
        System.out.println(f("?"));

        System.out.println(f("ab"));
        System.out.println(f("aa"));
        System.out.println(f("Aba"));

        System.out.println(f("Amor, Roma"));
        System.out.println(f("Amor, Rxma"));

    }

    private static boolean f(String a) {
        final List<Character> ignore = Arrays.asList(' ','.',',','?','!',':','-');

        a = a.toLowerCase();//todo performance. Can we downshift a char easily?
        int lo = 0;
        int hi = a.length() - 1;
        while (hi >= lo) {

            char clo = a.charAt(lo);
            while (lo < a.length() -1 && ignore.contains(clo)) {
                clo = a.charAt(++lo);
            }
            char chi = a.charAt(hi);
            while (hi > 0 && ignore.contains(chi)) {
                chi = a.charAt(--hi);
            }

            if (hi < lo) break;

            if (a.charAt(lo) != a.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
