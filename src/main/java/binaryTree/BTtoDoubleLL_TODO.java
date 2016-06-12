package binaryTree;



import util.DoubleLLNode;

import java.util.LinkedList;

import static binaryTree.BTUtil.*;

/**
 * Created by irene on 6/4/16.
 */
public class BTtoDoubleLL_TODO {

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
        System.out.println(inorder(n23));

        DoubleLLNode llist = flat(n23);

        System.out.println(llist);
    }

    private static DoubleLLNode flat(Node cur) {
        if (cur == null) return null;
        return null;
    }
}
