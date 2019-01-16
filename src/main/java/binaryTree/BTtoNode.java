package binaryTree;

import static org.junit.Assert.assertEquals;

public class BTtoNode {

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description
    // Convert BT to doublly LL
    static class Node {
        Node left;
        Node right;
        Node prev;  //left for LL
        Node next;
        int val;

    }

    static Node[] a = new Node[2];  //Node[0] is begin and other is end

    //https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
    public static void main(String[] args) {
        BTUtil.Node n25 = new BTUtil.Node(25);
        BTUtil.Node n30 = new BTUtil.Node(30);
        BTUtil.Node n36 = new BTUtil.Node(36);
        BTUtil.Node n12 = new BTUtil.Node(12);

        BTUtil.Node n15 = new BTUtil.Node(15);
        BTUtil.Node n10 = new BTUtil.Node(10);


        n10.left = n12;
        n10.right = n15;
        n15.left = n36;
        n12.right = n30;
        n12.left = n25;


    }

    static Node[]  f(Node cur, Node parent) {

        if (cur == null) {
            return new Node[] {null,null};
        }
        Node[] rvLeft = f(cur.left, cur);
        Node[] rvRight = f(cur.right, cur);

        // insert cur bw left and right 
        cur.right = rvRight[0];
        rvRight[0].prev = cur;
        cur.left = rvLeft[1];
        rvLeft[1].next = cur;


        //cicular
        rvRight[1].next = rvLeft[0];
        rvLeft[0].prev = rvRight[1];

        // return head and tail for new list
        return new Node[] {rvLeft[0], rvRight[1]};
    }
}
