package linkedList;

public class PrintLL {

    static class Node {
        Node next;
        char val;

        Node(char v, Node n) {
            val = v;
            next = n;
        }
    }

    public static void main(String args[]) {
        Node b = new Node('b', null);
        Node a = new Node('a', b);

        print_rev(a);
        print_fwd(a);
    }


    static void print_rev(Node cur) {
        if (cur == null) return;
        print_rev(cur.next);
        System.out.println(cur.val);
        return;
    }

    static void print_fwd(Node cur) {
        if (cur == null) return;
        System.out.println(cur.val);
        print_fwd(cur.next);
        return;
    }
}