package binaryTree;


import binaryTree.BTUtil.Node;

import java.util.Stack;

public class IterativeInorderBT {

    static Stack<Node>  stack = new Stack<>();

    static void iterate(Node root) {
        stack.push(root);
        Node cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

    }
    public static void main(String args[]){

        Node b40 = new Node(40,null,null);
        Node b18 = new Node(18,null, null);
        Node b25 = new Node(25,null,null);
        Node b32= new Node(32,null,null);
        Node b31= new Node(31,b32,null);
        Node b20 = new Node(20,b18,b31);
        Node root = new Node(30,b20,b40);
        IterativeInorderBT.iterate(root);
    }
}