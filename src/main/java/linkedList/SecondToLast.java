package linkedList;

import linkedList.LinkListUtil.Node;
public class SecondToLast {
    /**
     * googrich data struct and algo in python
     * find second to last node in a singly linked list
     */

     /**
        node
     */

     static Node head = null;
     static Node tail = head;

     public static void main(String args[]){

         head = new Node('a', null);
         tail = head;
         for ( char c = 'b'; c<'j'; c++) {
            Node x = new Node(c,null);
            tail.nxt = x;
            tail = x;
         }
         LinkListUtil.print(head);

         Node secondLast = findSecondLast();
         System.out.println("secondlast:"+secondLast);
     }

     static Node findSecondLast() {
       if (head==null || head.nxt == null) throw new IllegalArgumentException();
       Node cur = head;
       while ( cur.nxt.nxt != null){
           cur=cur.nxt;
       }
       return cur;
     }
}
