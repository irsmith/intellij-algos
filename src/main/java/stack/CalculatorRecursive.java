package org.skup.stack;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

/**
 *recursive
//http://stackoverflow.com/questions/4073069/recursive-expression-evaluator-using-java

 */
public class CalculatorRecursive {
	enum Operator {
		plus, mult
	};

	static Pattern add = Pattern.compile("\\\\+");
	static Pattern nbr = Pattern.compile("-?[0-9]+");

	static Pattern mult = Pattern.compile("\\*");

	public static void main(String[] args) {
		String t1 = "+ 2 4";
		String t2 = "* 8 ( + 7 12 )";
		String t3 = "+ 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )";

		assertEquals("+", t1.substring(0, 2).trim());
		assertEquals("2 4", t1.substring(2));

		assertEquals("6", calc(t1, null, null, null));

		assertEquals(26208, calc(t3, null, null, null));
		assertEquals(152, calc(t2, null, null, null));

	}

	private static String calc(String blob, String a1, String a2, Operator op) {

		if (blob == null || blob.isEmpty() || blob.equals(")"))
			return "";
		String _op = blob.substring(0, 2).trim();
		blob = blob.substring(2);
		op = getOp(_op);
		String _a1 = blob.substring(0, 2).trim();
		blob = blob.substring(2);

		String tmp = blob.substring(0, 2).trim();
		blob = blob.substring(2);
		String _a2 = null;

		if (tmp.equals("(")) {
			_a2 = calc(blob, null, null, null);
		} else {
			_a2 = tmp;
		}

		String res = perform(Integer.valueOf(_a1), Integer.valueOf(_a2), op);
		return res;
	}

	private static Operator getOp(String s) {
		if (s.equals("+"))
			return Operator.plus;
		else
			return Operator.mult;
	}

	private static String perform(int lhs, int rhs, Operator op) {
		int value = (op == Operator.plus) ? lhs + rhs : lhs * rhs;
		return String.valueOf(value);
	}
}
