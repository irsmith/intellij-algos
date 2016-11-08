package strings;


// Print duplicate elements in a given string with alphabet size R=256.
public class PrintDuplicates {
    public static void main(String[] args) {
        f("bannasAndApples");
    }
    private static void f(String a) {
        int cnt[] = new int[256];
        for (int i = 0; i < a.length(); i++) {
            int idx = a.charAt(i);
            if (cnt[idx] == 1) {
                System.out.format("dup %s at %d %n",a.charAt(i), i);
            }
            cnt[idx]++;
        }
    }
}
