package binaryTree;
import java.util.LinkedList;
import java.util.List;

public  class BTUtil {
	public static class Node {
		Node left;
		Node right;
		int val;
        Node nxt;

		public Node(int v, Node left, Node right) {
			this.left=left;
			this.right=right;
			val = v;
		}

		Node(int v) {
			val = v;
		}

		public Node(int v, Node next) {
			nxt = next;
			val = v;
		}


		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}

	Node root = null;

	public BTUtil(int[] a) {
		// if you want balanced, sort it
		// Arrays.sort(a);
		root = null;
		for (int i = 0; i < a.length; i++) {
			root = insert(a[i], root);

		}
	}

	private int[] convertListToPrimitive(List<Integer> alist) {
		int[] rv = new int[alist.size()];
		// convert list to primitive array. Java has no built in to do this
		for (int i = 0; i < alist.size(); i++) {
			rv[i] = alist.get(i);
		}
		return rv;
	}
	
	public BTUtil(List<Integer> alist) {
	    root = null;
		for (int i:alist) {
			root = insert(i, root);
		}
	}

	// Insert a new node v to root n to BT.  If v < N.val  recursively ask insert() to insert v under the left node.
	private Node insert(int v, Node n) {

		// find where v should go then insert it
		if (n == null)
			return new Node(v);
		if (v == n.val) {
			// do nothing
		} else if (v < n.val) {
			n.left = insert(v, n.left);
		} else {
			n.right = insert(v, n.right);
		}
		return n;
	}

	/** Inorder */
	@Override
	public String toString() {
		return inorder(root);
	}

	public static String inorder(Node n) {
		if (n == null)
			return "";
		return " l:" + inorder(n.left) + " n:" + String.valueOf(n.val) + " r:"
				+ inorder(n.right);
	}

	String levelOrder() {
		List<Integer> rv = new LinkedList<Integer>();

		List<Node> ll = new LinkedList<Node>();
		ll.add(root);
		while (!ll.isEmpty()) {
			Node n = ll.remove(0); // not get! remove!
			if (n == null)
				continue;
			rv.add(n.val); // visit
			ll.add(n.left); // add children
			ll.add(n.right);
		}
		return rv.toString();
	}

	public static void main(String[] args) {

		int[] a = new int[] { 5, 3, 8, 2, 0, 5, 4, 4, 9, 10, 11, 12, 13, 14 };
		BTUtil bst = new BTUtil(a);
		Node r = bst.getRoot();
		System.out.println(bst);  // prints in orderc
		System.out.println(bst.levelOrder());

		// int[] a = new int[] {5,3,8,2,0,5,4,4};
		// princeton.BST bst = new princeton.BST(a);
		// Node r = bst.getRoot();
		// System.out.println(bst);

	}

	private Node getRoot() {
		return root;
	}


}
