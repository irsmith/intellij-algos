package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LenLongestNonrepeat {

    int max = 0;
    int len = 0;
    int start = 0;
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int len = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i),i);
                len += 1;
            }else{
                if(map.get(s.charAt(i)) < start){
                    map.put(s.charAt(i),i);
                    len += 1;
                }else{
                    start = map.get(s.charAt(i)) + 1;
                    len = i - start+1;
                    map.put(s.charAt(i), i);
                }
            }
            if(len > max){
                max = len;
            }
        }
        return max;
    }

    public static void main(String args[]){
            String a = "abcabcbb";
            a="pwwkew";
            a="bbbb";

            //a="";
            //a="z";
            a="au";

            LenLongestNonrepeat soln = new LenLongestNonrepeat();
            final int i = soln.lengthOfLongestSubstring(a);
            System.out.printf("%d",i);


        }

}
