package stack;

import java.util.Stack;

/**
 * Created by irene on 6/1/16.
 */
public class PermuteUsingStack {
    static class F {
        public String accumulator;
        public String remain;

        public F(String a, String s) {
            this.accumulator = a;
            this.remain = s;
        }
    }

    public static void main(String[] args) {
        String orig = "abcd";

        Stack<F> stack = new Stack<>();
        stack.push( new F("", orig));
        while (!stack.isEmpty()) {
            F f = stack.pop();
            if (f.remain.length() == 1) {
                //base case
                System.out.println(f.accumulator);
                continue;
            } else {
                for (int i=0;i< f.remain.length();i++) {
                    String accumulator = f.accumulator + f.remain.substring(i,i+1);
                    String rhs =  f.remain.substring(0,i)+ f.remain.substring(i+1);
                    //System.out.format("push accum:%s rhs:%s %n",accumulator,rhs);
                    stack.push(new F(accumulator, rhs));
                }
            }
        }
    }
}
