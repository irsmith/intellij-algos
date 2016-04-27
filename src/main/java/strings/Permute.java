package strings;

/**
 * Created by irene on 4/2/16.
 */
public class Permute {
    public static void main(String[] args) {
        String s = "abc";
        f("", s);
    }

    private static void f(String prefix, String remain) {
        if (remain.length()==0) {
            System.out.println(prefix);
        } else {
            for (int i=0;i<remain.length();i++) {
                f(prefix + remain.charAt(i), remain.substring(0,i)+ remain.substring(i+1,remain.length()));
            }
        }

    }
}
