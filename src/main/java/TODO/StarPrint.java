package org.skup.TODO;

public class StarPrint {

	public static void main(String[] args) {

		System.out.println(rec("running", 0));
	}

	private static String rec(String a, int lo) {

		if (lo == a.length() - 1)
			return a.substring(lo);
		
        return a.substring(lo, lo+1) + '*' + rec(a, lo+1);

	}
}
