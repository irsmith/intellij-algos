package linkedList;

import linkedList.LinkListUtil.Node;

public class ReverseLL {
	Node h;

	public static void main(String[] args) {

		Node nc = new Node('c', null);
		Node nb = new Node('b', nc);
		Node na = new Node('a', nb);
		LinkListUtil.print(na);

		Node newhead = rev(na);
		LinkListUtil.print(newhead);

	}

	private static Node rev(Node cur) {
		if (cur.nxt == null) {
			return cur; // new head
		}

		Node second = cur.nxt; 
		Node revOfSecond = rev(second);
		Node lastOfSecondList = second;
		lastOfSecondList.nxt = cur; // attach cur to end of reverse of second
		cur.nxt = null;
		return revOfSecond;
	}
}
