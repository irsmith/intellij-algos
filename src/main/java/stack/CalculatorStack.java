package org.skup.stack;

import static org.junit.Assert.*;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * + 2 4 8 ( + 7 12) ( + 7 ( * 8 12 ) ( * 2 (+ 9 4) 7 ) 3 )
 * 
 * @author issmith1
 *
 */
public class CalculatorStack {
	static Pattern add = Pattern.compile("\\\\+");
	static Pattern nbr = Pattern.compile("-?[0-9]+");
	static Stack<String> stack = new Stack<String>();

	static Pattern mult = Pattern.compile("\\*");

	public static void main(String[] args) {
		assertTrue(nbr.matcher("-35").matches());

		assertTrue("+".equals("+"));

		String t1 = "+ 2 4";
		String t2 = "* 8 ( + 7 12 )";
		String t3 = "+ 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )";

		assertEquals(26208, calc(t3));

		assertEquals(6, calc(t1));
		assertEquals(152, calc(t2));


	}

	private static int calc(String t) {
		String[] a = t.split("\\s");
		for (String token : a) {
			if (token.equals(")")) {
				stack.push(String.valueOf(perform()));
			} else if (token.equals("(")) {
				//?
			} else if (token.equals("+") || token.equals("*")) {
				stack.push(token);
			} else if (nbr.matcher(token).matches()) {
                stack.push(token);
			} else {throw new AssertionError();}
		

		}
		stack.push(String.valueOf(perform()));

		return Integer.parseInt(stack.pop());
	}

	private static int perform() {
		int lhs = Integer.parseInt(stack.pop());
		int rhs = Integer.parseInt(stack.pop());
		boolean isPlus = stack.pop().equals("+");
		return isPlus ? lhs + rhs : lhs * rhs;
	}
}
