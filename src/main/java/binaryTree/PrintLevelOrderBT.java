package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static binaryTree.BTUtil.*;

/**
 * Created by issmith1 on 4/7/16.
 */
public class PrintLevelOrderBT {

    public static void main(String[] args) {


        Node b40 = new Node(40,null,null);
        Node b18 = new Node(18,null, null);
        // BTUtil.Node b25 = new BTUtil.Node(25,null,null);
        Node b32= new Node(32,null,null);

        Node b31= new Node(31,b32,null);

        Node b20 = new Node(20,b18,b31);
        Node root = new Node(30,b20,b40);

        int height = h(root, -1);
        System.out.println("Height: " + height);
        printLevelOrder(root, height);
    }

    /*
     NOTE
     Java LinkedList class is a member of the Java Collections Framework.
     It is an implementation of the List and Deque interfaces.
     Internally, it is an implemented using Doubly Linked List Data Structure.
     */
    static final Node SENTINAL = new Node(Integer.MIN_VALUE, null);
    private static void printLevelOrder(Node root, int maxHeight) {
        Queue<Node> queue = new LinkedList<>();

        int level = 0;
        Node cur;
        queue.add(root);
        queue.add(SENTINAL);
        while (level < maxHeight) {
            cur = queue.poll();
            if (cur == null) return;;
            boolean endLevel = false;
            if (cur == SENTINAL) {
                endLevel = true;
            } else {
                // enq non null children
                if (cur.left != null) queue.add(cur.left); // add to end of list
                if (cur.right != null) queue.add(cur.right); // add to end of list
                System.out.print(cur.val + " ");

            }
            if (endLevel == true) {
                System.out.println("L:" + level++);
                queue.add(SENTINAL);
            }

        }

    }

    /**
     *
     * @param root
     * @param cur
     * @return
     */
    private static int h(Node root, int cur) {
        if (root==null) return cur;
        int lefth=h(root.left, cur+1);
        int righth=h(root.right, cur+1);
        return Math.max(lefth,righth);
    }

}
