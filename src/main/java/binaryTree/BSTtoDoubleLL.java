package binaryTree;

import java.util.Collections;
import java.util.LinkedList;

import binaryTree.BTUtil.Node;

public class BSTtoDoubleLL {

	public static void main(String[] args) {
		Node n23 = new Node(23);
		Node n8 = new Node(8);
		n23.left = n8;
		n8.right = new Node(13);
		Node n35 = new Node(35);
		Node n31 = new Node(31);
		Node n46 = new Node(46);
		Node n30 = new Node(30);
		Node n32 = new Node(32);
		n23.right = n35;
		n35.left = n31;
		n35.right = n46;
		n31.left = n30;
		n31.right = n32;
		System.out.println(BTUtil.inorder(n23));

		LinkedList<Integer> llist = flat(n23);

		System.out.println(llist);
	}

	private static LinkedList<Integer> flat(Node cur) {

		if (cur ==null) {
			return new LinkedList<Integer>();
		}
		
		LinkedList<Integer> left = flat(cur.left);
		LinkedList<Integer> right = flat(cur.right);

		LinkedList<Integer> mid = new LinkedList<Integer>();
		mid.add(cur.val);

		// join middle list to end of left 
		left.addAll(mid);
		left.addAll(right);
		

		return left;
	}


	private static void printll(Node head) {
		for (Node cur = head; cur.nxt != null; cur = cur.nxt) {
			System.out.print(cur.val + " ");
		}
		System.out.println();
	}
}
