package strings;

public class FindSubstringNaive {
    public static void main(String[] args) {
        int cnt=0;
        String text = "aaaallsseashells";
                     //01234567890123456
        String pat = "ssea";
        for (int i=0;i<text.length() - pat.length();i++) {
            for (int j=0; j<pat.length();j++) {
                cnt++;
                if (pat.charAt(j) == text.charAt(i+j)) {
                    j++;
                    if (j == pat.length()-1) {
                        System.out.println("found at i=:"+i);
                        System.exit(1);
                    }
                } else {
                    j=0;
                    break;
                }
            }
        }
        System.out.println("not found");
    }
}
