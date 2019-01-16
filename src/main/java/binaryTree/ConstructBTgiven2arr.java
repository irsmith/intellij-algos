package binaryTree;
/*
https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
//Construct array given its preorder list and its inorder list
/*
Inorder sequence: D B E A F C
Preorder sequence: A B D E C F
 */

// We want to know root; this is root=preorder[0].  Find root.val in inorder = i = 3
// Now descend on inoder lo=0 and hi=2
// inorder =i = 1
// now descent inordert 0,0

import static binaryTree.BTUtil.*;

public class ConstructBTgiven2arr {
    static char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};
    static char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'}; //has roots
    static int ipre = 0;
    static int V = inorder.length;

    /** IN ORDER */
static void printInorder(Node node) {
    if (node == null)
        return;

    /* first recur on left child */
    printInorder(node.left);

    /* then print the data of node */
    char c =(char)node.val;
    System.out.print(new Character(c) + " ");

    /* now recur on right child */
    printInorder(node.right);
}


static Node make(int lo, int hi) {
        if (lo > hi) return null;

        char curChar = preorder[ipre++];
        System.out.println("visit:"+curChar);
        if (lo == hi) {
            return new Node(curChar, null,null);
        }
        Node n =  new Node(curChar);
        // goal is to set left and right for n.  TO do so we need to pass in ipre to identify next root,
        // and left range and right range.  To find next range find value of curChar in the inorder array


        int mid = 0; // not really middle but separates left from right
        while (preorder[mid] != curChar) {
            mid++;
        }
        n.left = make(lo, mid-1);
        n.right = make(mid+1,  hi);
        return n;

    }



    public static void main(String[] args) {
        Node root =  make(0, V-1);
        System.out.println("inorder representation of BT:");
        printInorder(root);
    }


}