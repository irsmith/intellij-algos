package linkedList;

import static linkedList.LinkListUtil.print;

import linkedList.LinkListUtil.Node;


/**
 * (this is the approach in The Little Lisper):
 http://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
  What is the reverse of null (the empty list)? null.
 What is the reverse of a one element list? the element.
 What is the reverse of an n element list? the reverse of the second element on followed by the first element.
 *
 */
public class RevLL {

	private static Node rev(Node prev, Node cur, Node newHead) {

		System.out.format("prev:%s, cur:%s, newHead:%s %n", prev, cur, newHead);
		if (cur==null) return null;
		if (cur.nxt == null) return cur;
		
		Node save = cur.nxt; // SAVE Second element bec. this will become last and we need to make this null
		
		
		Node newhead = rev(cur, save, newHead);   //rev(B) returns C->B
		cur.nxt = null;//terminate the list
		save.nxt = cur; // save is now the end of the list: join new reversed list to cur
		return newhead;
	}

	public static void main(String[] args) {
		Node c = new Node('c', null);
		Node b = new Node('b', c);
		Node a = new Node('a', b);
		print(a);
		Node newhead = rev(null, a, null);
		print(newhead);

	}
}
