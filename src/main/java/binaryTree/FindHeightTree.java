package binaryTree;

import binaryTree.BTUtil.Node;
import static org.junit.Assert.*;

public class FindHeightTree {
	// A tree consisting of only a root node has a height of 0.
	// The height of a node is the number of edges from the node to the deepest leaf.
	public static void main(String[] args) {
		Node n23 = new Node(23);
		Node n18 = new Node(18);
		n23.left = n18;

		FindHeightTree finder = new FindHeightTree();
		assertEquals(1, finder.getHeight(n23));
		Node n12 = new Node(12);
		n18.left = n12;
		assertEquals(2, finder.getHeight(n23));

		Node n8 = new Node(8);
		Node n15 = new Node(15);
		n12.left = n8;
		n12.right = n15;
		assertEquals(3, finder.getHeight(n23));

		Node n5 = new Node(5);

		n8.left = n5;
		assertEquals(4, finder.getHeight(n23));

	}

	private int getHeight(Node cur) {

		if (cur == null || (cur.left == null && cur.right == null))
			return 0;

		int h = 0;
		int left = getHeight(cur.left);
		int right = getHeight(cur.right);

		h = 1 + Math.max(left, right);
		return h;
	}

}
