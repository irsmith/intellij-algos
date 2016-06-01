package stack;

import java.util.Stack;

/**
 * Created by issmith1 on 6/1/16.
 *
 * Balanced parentheses
 write a function which checks if parentheses in expression are balanced.
 Given:(5+4)*( 2 +(4-7))
 Result: balanced

 Given:(5+4)*( 2 +(4-7)
 Result: !balanced

 */
public class BalancedParen {
    static char empty[] = new char[]{};
    static char oneClosed[] = new char[]{')'};
    static char aa[] = new char[]{'(', '(',')'};
    static char notBal[] = new char[]{'(','2','+','(','4','-','7',')'};
    static char bal[] = new char[]{'2','+','(','4','-','7',')'};

    public static void main(String[] args) throws Exception {
        System.out.println(     "expected=Bal, " + f(bal));
        System.out.println(     "expected=Bal, " + f(empty));
        System.out.println(     "expected=NotBal, " + f(oneClosed));
        System.out.println(     "expected=NotBal, " + f(aa));
        System.out.println(     "expected=NotBal, " + f(notBal));
    }

    private static String f(char[] a) throws Exception {
        String rv="balanced";
        Stack<Character> stack = new Stack<>();
        for (Character c: a ) {
            if (c == '(') {
                stack.push(new Character('('));
            } else if (c == ')') {
                if (stack.isEmpty()) return "notBalanced";
                Character expectOpenParen = stack.pop();
                if (expectOpenParen != '(') throw new Exception("internal error");
            }
        }
        return stack.isEmpty() ? "balanced" : "notBalanced";
    }
}
