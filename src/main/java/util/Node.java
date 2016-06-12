package util;

/**
 * Created by irene on 6/4/16.
 */
public class Node {
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
