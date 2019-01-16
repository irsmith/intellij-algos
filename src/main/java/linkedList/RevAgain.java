package linkedList;
import static linkedList.LinkListUtil.*;

public class RevAgain {
    public static void main(String[] args) {
        Node c = new Node('C', null);
        Node b = new Node('B', c);

        Node a = new Node('A', b);
        LinkListUtil.print(a);

        Node answ = rev(a);
        LinkListUtil.print(answ);

    }
    static Node rev(Node head){
        Node cur = head;
        Node prev = null;
        while (cur != null) {

            Node temp = cur.nxt;
            // one operation! then increment both pointers with caveat that we need a temp.
            cur.nxt = prev;

            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
