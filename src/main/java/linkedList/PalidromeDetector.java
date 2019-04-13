package linkedList;

import static linkedList.LinkListUtil.print;

import linkedList.LinkListUtil.Node;



// detect palidrome in single ll
public class PalidromeDetector {

// && cur.nxt != null
// for recursive solution 2 base cases:
// 1. what is reverse of null list?
// 2. what is reverse of one-node list? cur
// takes HEAD as input then 'cur' is internal pointer not arg.

static Node rev(Node head) {
       Node cur=head;
       Node newHead = null;

       while (cur != null ) {

              Node tmp = cur.nxt;
              cur.nxt = newHead;
              size++;
              newHead = cur; // increment loop
              cur = tmp;  // increment loop
       }
       return newHead;

}



// need half way point thus O(N) time
// reverse the list as we are counting -- could do in place but do need memory of the values
// walk reverse list up to mid, while saving values and comare

    // This reversal is DESTRUCTIVE of the original array
    //  we need non destructive
static int size;

static boolean isPalidrome(Node root) {
   Node revRoot = rev(root);
   print(revRoot);

   int mid = size/2;
   Node p1 = root;
   Node p2 = revRoot;
   int i=0;
   while (i < mid){
       //return false if mismatch
       if (p1.v == p2.v) {
              p1=p1.nxt;
              p2=p2.nxt;
        } else {
          return false;
       }
   }
   return true;
}


public static void main(String[] args){
    Node c = new Node('x', null);
    Node b = new Node('b', c);
    Node a = new Node('x', b);
    print(a);
    //Node newhead = rev(a);
    //print(newhead);
    System.out.printf("%b %n",isPalidrome(a));

}

}
