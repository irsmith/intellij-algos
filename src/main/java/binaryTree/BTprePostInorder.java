package binaryTree;

import util.DoubleLLNode;

import static binaryTree.BTUtil.*;

//https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
public class BTprePostInorder {

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
        pre(n23);
        System.out.println();
        post(n23);
        System.out.println();
        inorder(n23);
        System.out.println();

    }

    private static void pre(Node cur) {
        if (cur == null) return;
        System.out.print(cur.val + " ");
        pre(cur.left);
        pre(cur.right);
    }
    private static void inorder(Node cur) {
        if (cur == null) return;
        inorder(cur.left);
        System.out.print(cur.val + " ");
        inorder(cur.right);
    }
    private static void post(Node cur) {
        if (cur == null) return;
        post(cur.left);
        post(cur.right);
        System.out.print(cur.val + " ");

    }
}
