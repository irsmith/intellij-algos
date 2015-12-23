package org.skup.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramfromHackerrank {

/*
 * find the minimum number of characters of the first string he needs to change to enable him to 
 * make it an anagram of the second string.
 * 
 10
hhpddlnnsjfoyxpciioigvjqzfbpllssuj
xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj
dnqaurlplofnrtmh
aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb
lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad
drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe
ubulzt
vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy
xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa
gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv


10
13
5
26
15
-1
3
13
13
-1
 */
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner s = new Scanner(System.in);
		int cnt = Integer.parseInt(s.nextLine());
		while (cnt > 0)  {
			cnt--;
			String w = s.nextLine();

			//String w = "hhpddlnnsjfoyxpciioigvjqzfbpllssuj";//s.nextLine();
			//String w3 = s.nextLine();//"xaxbbbxx";
			if ((w.length() % 2) == 1) {
				System.out.println(-1);
				continue;
			}
			int mid = w.length() / 2;
			String s1 = w.substring(0, mid);
			String s2 = w.substring(mid);
			System.out.format("len %d %d %n", s1.length() ,s2.length());

			char []c1= s1.toCharArray();
			char []c2 = s2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			s1= String.valueOf(c1);
			s2 = String.valueOf(c2 );
			System.out.format("str %s %s %n", s1,s2);

			if (s2.equals(s1 )) {
				System.out.println(0);
				continue;
			}
			// 
			Map<Character,Integer> m = new HashMap<Character,Integer>();  // for each string , map char to number of occurrences
			Map<Character,Integer> m2 = new HashMap<Character,Integer>();

			for (int j=0;j<c1.length;j++) {
				Character key = c1[j];
				if (m.containsKey(key)) {
					int i = m.get(key);
					m.put(key, ++i);
				} else {
					m.put(key, 1);
				}
				key = c2[j];
				if (m2.containsKey(key)) {
					int i = m2.get(key);
					m2.put(key, ++i);
				} else {
					m2.put(key, 1);
				}
			}

			// heres the tricky part::
				// using counts, find number of char changes need to execute on STRING1 such that it matches string2
				// s1=abxx
				// s2=bbxx
			// map1={a=1, b=1, x=2}
			// map2 =    {b=2, x=2}
			// since s1 MUST equal s2, then if we del from s1 ... so if you summed all diffs they would be zero
			// if diff is positive, you must del from s1 that amt
			// if diff is neg. 
			// Map<Character,Integer> sum = new HashMap<Character,Integer>();
			int n=0;

			for (char key = 'a'; key <= 'z'; key++) {
				int cnt1= m.get(key) == null? 0 :m.get(key	);
				int cnt2= m2.get(key) == null? 0 :m2.get(key);
				int diff = cnt1-cnt2;
				if (diff > 0) {
					n += diff;
				}
				//sum.put(key, cnt1-cnt2);
			}


			System.out.println(n);

		}

		s.close();            
	}
}
