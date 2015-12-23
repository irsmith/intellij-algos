package org.skup.TODO;

import java.util.Scanner;

public class FunnyString {
	public static void main(String[] args) {
		f("acxz");
		f("bcxz");
		Scanner s = new Scanner(System.in);
		Integer tests = Integer.parseInt(s.nextLine());
		while (tests-- > 0) {
			String s1 = s.nextLine();
			f(s1);
		}
	}

	private static void f(String s1) {
		char[] car = s1.toCharArray();
		int j = car.length - 1;
		int i = 1;
		boolean funny = true;
		while (j > i) {
			int left = Math.abs(car[i] - car[i - 1]);
			
			i++;
			int right = Math.abs(car[j - 1] - car[j]);
			if (left != right) {
				funny = false;
				break;
			}
			j--;
		}
		if (funny) {
			System.out.println("Funny");

		} else {
			System.out.println("Not Funny");

		}
	}
}
