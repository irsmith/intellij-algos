package linkedList;

import linkedList.LinkListUtil.Node;

/*
clarifying q:
   will I be given null list?

 */
public class ReverseLL {
	Node h;

	public static void main(String[] args) {

		Node nr = new Node('r', null);
		Node ne = new Node('e', nr);
		Node nt = new Node('t', ne);
		Node na = new Node('a', nt);
		Node nw = new Node('w', na);

		LinkListUtil.print(nw);
		Node newhead = null;

//		newhead = rev(nw);
//		LinkListUtil.print(newhead);

		newhead = rec_rev(nw);
		LinkListUtil.print(newhead);


	}

	//recursive
	private static Node rec_rev(Node cur) {

		//if (cur==null) return null; //debug:: no because I append to second list
		if (cur.nxt==null) return cur; //fix

		Node secondList = cur.nxt; //its first element before the call
		Node attachSingleChar = cur; // dont need attachSingleChar (could use cur) but it helps me learn
		attachSingleChar.nxt = null;

		Node newhead = rec_rev(secondList);

		// edge is last element of second list after the call
		secondList.nxt = attachSingleChar;
		//cur.nxt = null;  // result if here is "r w" for 'water'  BUG!
		return newhead;
	}

	private static Node rev(Node head) {
		Node cur = head;
		Node prev = null;
		Node newHead = null;
		while (cur != null) {

			Node save = cur.nxt;
			cur.nxt = prev;
			newHead = cur;
			// increment
			prev = cur;  //example of debug::other order is wrong
			cur = save;  //example of debug::

		}
		return newHead;
	}


}
