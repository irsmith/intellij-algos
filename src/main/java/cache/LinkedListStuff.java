package cache;

import linkedList.LinkListUtil;

import linkedList.LinkListUtil.*;

public class LinkedListStuff {


    private LinkListUtil.Node head;


    public static void main(String args[]) {

        LinkedListStuff cache = new LinkedListStuff();


        Node nc = new Node('c',null);
        Node nb = new Node('b',nc);
        cache.head = new Node('a',nb);

        LinkListUtil.print(cache.head);

        Node r = cache.reverse();
        LinkListUtil.print(r);

    }

    private Node reverse() {
        Node NL=null;
        Node n = head;
        while (n !=null) {
        //for (Node n = head ;n != null; n=n.nxt) {  CANNOT use for loop since n is mutated in the loop!
            //System.out.println(n.v);
            Node tmp = n.nxt;  // save for incrementing

            n.nxt = NL;   //n.nxt is getting mutated thus need to save n.nxt as opposed to n.


            NL = n;  //increment in loop.
            n = tmp; //
        }
        return NL;
    }
}
