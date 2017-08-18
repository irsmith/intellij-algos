package TODO;

/**
 * Created by issmith1 on 8/17/17.
 */
public class Stars {
    public static void main(String[] args) {
        f("stars", 0);

    }

    static void f(String a, int i) {
        if (i == a.length()) return;
        System.out.print(a.charAt(i)+"*");
        f(a, ++i);
    }
}
