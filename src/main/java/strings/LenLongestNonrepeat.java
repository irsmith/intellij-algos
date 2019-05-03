package strings;

import java.util.HashSet;
import java.util.Set;

public class LenLongestNonrepeat {

        public int lengthOfLongestSubstring(String s) {
            if (s.length()<=1) return s.length();
            if (s == null) return 0;
            Set<Character> set = new HashSet<>();

            int rv = 1;
            for (int i=0;i<s.length(); i++) {
                set.add(s.charAt(i));
                int localMax = 1;

                for (int j=i+1;j<s.length();j++) {
                    if (! set.contains(s.charAt(j))) {

                        localMax++;
                        set.add(s.charAt(j));
                        rv = Math.max(rv, localMax);

                    } else {
                        break;
                    }
                }
                set.clear();
            }
            return rv;
        }
        public static void main(String args[]){
            String a = "abcabcbb";
            a="pwwkew";
            a="bbbb";

            //a="";
            //a="z";
            //a="au";

            LenLongestNonrepeat soln = new LenLongestNonrepeat();
            final int i = soln.lengthOfLongestSubstring(a);
            System.out.printf("%d",i);


        }

}
