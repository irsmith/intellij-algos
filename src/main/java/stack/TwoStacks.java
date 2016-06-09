package stack;

import java.util.ArrayList;

/**
 * Created by issmith1 on 6/1/16.
 */
public class TwoStacks {
    static class Two {
        private int capacityTotal = -1;
        private char a[];
        static int tail1 ;
        static int tail2 ;

        public Two(int capacity) {
            a = new char[capacity];
            capacityTotal = capacity;
            tail1 = -1;
            tail2 = capacity;
        }

        public char pop1(){
            if (isEmpty1()) throw new RuntimeException("empty1");
            char r = a[tail1--];
            return r;
        }

        public char pop2(){
            if (isEmpty2()) throw new RuntimeException("empty2");
            char r = a[tail2--];
            return r;
        }
        public  void push1(char data){
            if (tail1 == tail2) throw new RuntimeException("full");
            a[++tail1] = data;
        }
        public  void push2(char data){
            if (tail1 == tail2) throw new RuntimeException("full");
            a[++tail2] = data;
        }

        private boolean isEmpty1() {
            return tail1 == -1;
        }
        private boolean isEmpty2() {
            return tail1 == capacityTotal;
        }


    }


    public static void main(String[] args) {
         int N = 5;

        char [] data = {'a','1','b', 'c'}; // numbers go to Stack1 letters Stack2
        // test 1 pop empty
        // test 2, push all data
        Two two = new Two(N);

    }
}
