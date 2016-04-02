package recursion;

/**
 * Created by issmith1 on 3/30/16.
 */
public class FibonacciTest {

    static int[] Fib = new int[100];

    public static void main(String args[]){
        int n = 6;


        System.out.println("Fibonaci of " + n + " = " + Fibonacci(n));
        System.out.println("Fibonaci Iterative  " + n + " = " + FibonacciIterative(n));

    }

    private static int Fibonacci(int x) {
        if (x == 0){
            return Fib[0] = 0;

        }
        if (x == 1){
            return Fib[1] = 1;
        }

        if (Fib[x] == 0) {
            Fib[x] = Fibonacci(x - 1) + Fibonacci(x - 2);
        }
        return Fib[x];

    }


    private static int FibonacciIterative(int x){
        int a = 0;
        int b = 0;

        for (int i = 0; i <= x; i++){
            if (i == 0){
                b = 0;

            } else if (i == 1){
                b = 1;
            } else {
                int temp = a;
                a = b;
                b = b + temp;
            }

        }

        return b;
    }


}
