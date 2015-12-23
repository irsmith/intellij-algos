package org.skup.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;
import java.util.regex.Pattern;

public class CalculatorIterateStack {
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

	private static Object calc(String t3) {
		// TODO Auto-generated method stub
		return null;
	}

}
