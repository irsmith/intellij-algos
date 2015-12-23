package org.skup.strings;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

//http://www.javainterview.net/facebook/find-string-matches
//http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Text/trie01.html
/**
 * 
 Given a dictionary of words, return an array of the words whose match.
 * 
 * (i.e. pattern "c.t" match with "cat", "cut", etc.
 * 
 * Because the dot notation stand for ANY character)
 * 
 * @author issmith1
 *
 */
public class Trie {

	public static class Node {

		public Node[] a = new Node[26]; // null or not null means c is present
		public Object val = null; // if not null then this is key

		public Character parent = null;
		public boolean leaf = true;

		void setChild(Node n, char cc) {
			int idx = cc - 'a';
			leaf = false;
			a[idx] = n;
		}

		boolean hasChar(char c) {
			return getChild(c) != null;
		}

		Node getChild(char c) {
			int idx = c - 'a';
			return a[idx];
		}

		@Override
		public String toString() {
			List<Character> list = new ArrayList<Character>();
			for (int i = 0; i < a.length; i++) {
				if (a[i] != null)
					list.add((char) (i + 'a'));
			}
			return String.format("parent= %s leaf =%b endword =%b children: %s", parent, leaf, (val != null),
					list.toString());
		}
	}

	public static void main(String[] args) {
		String[] dict = { "cat", "cut", "cup", "cipp" };

		Node root = trieFactory(dict);
		printTrie(root);
		String patx = "c.t";
		String pat = "cip";

		String match = "";
		List<String> res = find(root, pat.toCharArray(), 0, match);

		System.out.println("found "+res);
	}

	private static void printTrie(Node cur) {
		if (cur == null)
			return;
		System.out.println(cur);
		for (int i = 0; i < 26; i++) {
			printTrie(cur.a[i]);
		}

	}

	/*
	 * 
	 */
	// given pattern and its idx, return list of words matching that pattern

	//
	private static List<String> find(Node cur, char[] pat, int patidx, String match) {
		char curchar = pat[patidx];
		System.out.println("top " + curchar);

		if (patidx == pat.length - 1 && // at the end of the key
				//cur.hasChar(curchar)) { // and char match --wrong!
			cur.getChild(curchar).val != null) { // end word marker

			// we have a matched word!
			System.out.println("match key " + curchar);

			Node child = cur.getChild(curchar);
			match = match + curchar;
			List<String> list = new ArrayList<String>();
			list.add(match);
			return list;
		}
		// if not end of pattern keep going
		if (cur.hasChar(curchar)) {
			System.out.println("process " + curchar);
			return find(cur.getChild(curchar), pat, patidx + 1, match + curchar);
		}
		return new ArrayList<String>(); // not found
	}

	private static Node trieFactory(String[] dict) {
		Node root = new Node();
		for (String w : dict) {
			Node curnode = root;
            Character parent = null;
			char[] _word = w.toCharArray();
			boolean endword = false;
			for (int i = 0; i < _word.length; i++) {
				if (i == _word.length - 1)
					endword = true;
				char cc = _word[i];

				// 1. node doesnt exist, 2. node exist but char empty 3. node and char exist AND end 
				// of key 4. node and char exist but keep going
				// if this idx is null, add the next node which could be end of the key (or not)
				Node nxtnode = new Node();

				if (!curnode.hasChar(cc)) {
					nxtnode = new Node();
					curnode.setChild(nxtnode, cc);
				} else {
					nxtnode = curnode.getChild(cc);
				}
				// now we have next node and char is set in curnode
				if (endword) {
					nxtnode.val = new Object();
					continue;
				} 
				curnode = nxtnode;
			}
		}
		return root;
	}
}
