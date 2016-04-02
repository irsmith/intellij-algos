package recursion;

/**
 * Created by issmith1 on 3/30/16.
 */
//0, 1, 1, 2 , 3, 5, 8, 13, 21, 34
public class Fibonochhi {
    static int cach[] = null;
    static int K = 9;

    public static void main(String[] args) {
        cach = new int[K];
        cach[0]=0;
        cach[1] = 1;
        System.out.println(fib(K));
    }

    private static int fib(int i) {
          if (i<=1) return i;

          for (int j=2;j<=K;j++) {

              int next = cach[0] + cach[1];
              cach[0] = cach[1];
              cach[1] = next;
          }
        return cach[0] + cach[1];

    }

}
