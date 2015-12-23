package org.skup.strings;

public class InsertStar {

	public static void main(String[] args) {
		star("hello");
	}

	private static String star(String a) {
		if (a.length() ==1) {
			System.out.println(a);
			return "";
		}
		System.out.print(a.charAt(0) + "*");
		return star(a.substring(1)); // tail recursion
	}
}
