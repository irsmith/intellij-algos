package org.skup.linkedList;


public class LinkListUtil {
	
	
	
	public static class Node {
		public char v;
		public Node nxt;

		public Node(char v, Node nxt) {
			this.v = v;
			this.nxt = nxt;
		}

		@Override
		public String toString() {
			return Character.toString(v);
		}

	}

	public static void print(Node newHead) {
		Node n = newHead;

		while (n != null) {
			System.out.print(n.v + " ");
			n = n.nxt;
		}
		System.out.println();
	}
}
