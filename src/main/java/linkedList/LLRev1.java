package linkedList;

import static linkedList.LinkListUtil.print;

import linkedList.LinkListUtil.Node;

/**
 *
 */
public class LLRev1 {

	static Node newhead = null;

	private static Node rev(Node cur) {
		
		if (cur.nxt == null) {
			newhead = cur;
			return cur;
		}
		// http://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
		// what is reverse of null? null. BUT we need to inject new head
		// The key to visualizing thiis is, the IN parameter to rev() is second node in orig list.
		// and when rev() returns, the second node b is the LAST node of rev list
		// and when we originally call rev() the CUR node a will be after the LAST node that gets returned
		// It feels like we need Another parameter to keep track of the end of the reversed list, but we already have it!
		// 
		// Two lists: reverse of second , and cur.  When reverse of second returns
		// we join cur to end of revOfSecond
		
		Node second = cur.nxt; // SAVE second.... alternatively could pass this in?
		cur.nxt = null;// why cant we do this in the base case??
		
		Node revSecondList = rev(second); //IN param is head but when it returns, its last
		//System.out.print("revSecondList ");	print(revSecondList);

		second.nxt = cur; //attach first list to end of second list

		return revSecondList;

	}

	public static void main(String[] args) {
		Node d = new Node('d', null);
		Node c = new Node('c', d);
		Node b = new Node('b', c);
		Node a = new Node('a', b);
		print(a);
		rev(a);
		print(newhead);

	}
}
