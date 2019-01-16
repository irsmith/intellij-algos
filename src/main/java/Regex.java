import java.util.regex.Pattern;

public class Regex {
    static String simple = "\\d{3}[-\\.\\s]?\\d{3}[-\\.\\s]?\\d{4}";


    static String pp = " (\\d{3}[-\\.\\s]??\\d{3}[-\\.\\s]??\\d{4}|\\(\\d{3}\\)\\s*\\d{3}[-\\.\\s]??\\d{4}|\\d{3}[-\\.\\s]??\\d{4})";
    //static Pattern pattern = null;
    //static Regex.

    /*
     (\d{3}[-\.\s]??\d{3}[-\.\s]??\d{4}|\(\d{3}\)\s*\d{3}[-\.\s]??\d{4}|\d{3}[-\.\s]??\d{4})
     */
    public static void main(String[] args) {


        String a = "408-6664044";

        boolean b = a.matches(simple);
        System.out.println(b);
    }
}
