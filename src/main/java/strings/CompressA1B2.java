package strings;

public class CompressA1B2 {
    public static void main(String[] args) {
        String s = "abbccc";
        s = "abbcccd";

        int lo=0;
        int hi=0;
        StringBuilder sb = new StringBuilder();
        while (hi < s.length()) {
            if (hi+1 ==s.length()) {
                Integer sameLen = Math.max(hi - lo, 1);
                sb.append(s.charAt(hi)+sameLen.toString());
                break;
            } else {
                // lo=hi here. Increment hi until they are not equal
                while (hi < s.length() && (s.charAt(lo) == s.charAt(hi))) {
                    hi++;
                }
                Integer sameLen = hi - lo;
                sb.append(s.charAt(lo)+sameLen.toString());
                lo=hi;

            }
        }
        System.out.println("sb:"+sb.toString());
    }
}
