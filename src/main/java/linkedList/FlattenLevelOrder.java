package linkedList;


import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by issmith1 on 4/8/19.
 */
public class FlattenLevelOrder {

    public static class Node {
        public Node right;
        int val;
        public Node down;

        public Node(int v, Node right, Node down) {
            this.right=right;
            this.down = down;
            val = v;
        }
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
    
  
    public static void main(String[] args) {


        Node b2 = new Node(1,null,null);
        Node b9 = new Node(9,null, null);
        Node b17= new Node(17,null,b9);

        Node b20 = new Node(20,b17,b2);
        Node b4= new Node(4,b20,b17);
        Node root = b4;
        print(root);
        Node tail = b17;
        Node b99 = new Node(99,null,null);
        tail = insertToTail(b99, tail);
        print(root);

        final Node flatList = flatten(root);
        print(flatList);
    }

    private static Node insertToTail(Node newnode, Node tail) {
        newnode.right = null;
        tail.right = newnode;
        return newnode;
    }

    /*
     NOTE
     Java LinkedList class is a member of the Java Collections Framework.
     It is an implementation of the List and Deque interfaces.
     Internally, it is an implemented using Doubly Linked List Data Structure.
     */
    static final Node SENTINAL = new Node(Integer.MIN_VALUE, null,null);

    static Node flatten(Node root) {

        Node flatTail = SENTINAL;
        Node cur = root;
        Queue<Node> curQ = new LinkedList<>();
        Queue<Node> rightQ = new LinkedList<>();
        curQ.add(root);
        while (cur != null) {

            cur = curQ.poll(); // deque from head of curQ.
            if (cur == null) {
                break;
            }

            // enq right level
            if (cur.down != null) {
                rightQ.add(cur.down);
            }
            // load curq for current level
            if (cur.right != null) {
                curQ.add(cur.right);
            }

            // VISIIT add to end of flattened list
            cur.right = null;
            flatTail.right = cur;
            flatTail = flatTail.right;


            // if at end of level swap Qs
            if (cur.right == null) {
                curQ = rightQ;
                rightQ = new LinkedList<>(); //todo optimize
            }
        }
        return SENTINAL.right;
    }


    public static void print(Node newHead) {
        Node n = newHead;

        while (n != null) {
            System.out.print(n.val + " ");
            n = n.right;
        }
        System.out.println();
    }
}
