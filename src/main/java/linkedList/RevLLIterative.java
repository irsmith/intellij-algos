package linkedList;

import static linkedList.LinkListUtil.print;

import linkedList.LinkListUtil.Node;

public class RevLLIterative {
	
	public static void main(String[] args) {

		Node d = new Node('d', null);
		Node c = new Node('c', d);
		Node b = new Node('b', c);
		Node a = new Node('a', b);
		print(a);
		Node newh=rev(a);
		print(newh);
	}

	private static Node rev(Node a) {


		//everything is on same stack <thing> so we can save all
		Node prev=null;
		Node cur=a;
	    Node newHead = null;
		while(cur.nxt != null) {
			Node saveNxt=cur.nxt;
			cur.nxt.nxt=cur;
			cur.nxt = prev;
			
			// increment the loop
			cur=saveNxt;
			prev=cur;
		}
		
		return newHead;
	}
}
