package graph;

public class PrintStar {

    static String a = "star";

    public static void main(String[] args) {

        star(a,0);
    }

    private static void star(String a, int i) {
           if (i == a.length()) {
               return;
           }
        System.out.print(a.charAt(i)+ "*");
        star(a,i+1);
    }
}
