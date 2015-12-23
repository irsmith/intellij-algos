package org.skup.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MakeChange {
	static class Res{
		int level;
		Res(int l){
			this.level = l;
		}
		int thisMin;
		List<Integer> choice = new ArrayList<Integer>();
		
	}
	static List<Integer> denom = Arrays.asList(1, 3, 5); //N denominations, arbitrary unsorted 

	static {
		Comparator<Integer> cmp = Collections.reverseOrder();
		Collections.sort(denom, cmp);
	}

	static List<Integer> overall_set = new ArrayList<Integer>();

	static int bigo = 0;

	/*
	 * Given N coins with denomination, make change T min. # coins.
	 */
	public static void main(String[] args) {

		int Target = 21;
		Res res =  new Res(0);
		System.out.println("answ:" + makech(Target, res) + " set " + res.choice);
	}

	private static int makech(int T, Res res) {
		res.level++;
		if (T < 1) {
			return 0;
		}

		if (T == 1) {
			overall_set.add(1);
			return 1;
		}
		if (T == 3) {
			overall_set.add(3);
			return 1;
		}
		if (T == 5) {
			overall_set.add(5);
			return 1;
		}
		int minAllCminusVi = Integer.MAX_VALUE; //  min over i 0:n of Cnt(T-denom-i)
        int minChoice = -1;
		for (int c : denom) {
			if (T - c > 0) {
				int cntRemainder = makech(T - c, res);
				if (cntRemainder < minAllCminusVi) {
					minAllCminusVi = cntRemainder; 
                    minChoice =c;
				}
			}

		}
		//System.out.format("makech( %d) result: %d %n",T,1+minAllCminusVi);
	   if (res.level == 1)	res.choice.add(minChoice);
		return 1 + minAllCminusVi;
	}
}
