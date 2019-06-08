package linkedList;

/**
 * LEET
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */

public class TwoSumLeet {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answ = new ListNode(Integer.MAX_VALUE);//dummy
        ListNode answEnd = answ;
        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int v1=0, v2=0;
        while (!(cur1==null && cur2==null)) {
            if (cur1 == null) {
                //increment only cur2 and set v1 to zero
                v2 = cur2.val;
                cur2 = cur2.next;
                v1 = 0;
            } else if (cur2 == null) {
                // inc only cur1 and set v2 to zer0
                v1 = cur1.val;
                cur1 = cur1.next;
                v2 = 0;

            } else {
                v1 = cur1.val;
                cur1 = cur1.next;
                v2 = cur2.val;
                cur2 = cur2.next;
            }

            int localSum = v1 + v2 + carry;
            carry = localSum / 10;
            localSum = localSum % 10;

            // insert answer at END of answer

            ListNode newnode = new ListNode(localSum);
              //            if (answ == null) {  // we can use the dummy pattern and return answ.next
              //                answ = newnode;
              //                answEnd = newnode;
              //            } else {
              answEnd.next = newnode;
              answEnd = newnode;
        }
        if (carry == 1) {
            // add one to end of answer list
            ListNode newnode = new ListNode(carry);
            answEnd.next = newnode;
        }
        return answ.next;
    }
    /**
     * LEARNED: their example will omit edge cases.  Hint is that both m and N len are SAME.  Thus need case of diff.
     *
     Definition for singly-linked list.
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.

     Input: (6) + (7 )
     Output: 3 -> 1
     since: 6 + 7 = 13

     Input: (6 -> 2)  + (8)
     Output: 4 -> 3
     r: 26 + 8 =  34
     */
    public static void main(String a[]){
        TwoSumLeet s = new TwoSumLeet();
        ListNode b0=new ListNode(5);
        ListNode b1=new ListNode(6);
        ListNode b2=new ListNode(4);
        ListNode a0=new ListNode(2);
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(3);
        a0.next=a1;
        a1.next=a2;
        b0.next=b1;
        b1.next=b2;

        final ListNode answ = s.addTwoNumbers(a0, b0);

        for (ListNode y =answ; y != null; y=y.next)
             System.out.print(y.val+" ");
        System.out.println();
    }

    /*
        ListNode b0=new ListNode(5);
        ListNode b1=new ListNode(6);
        ListNode b2=new ListNode(4);
        ListNode a0=new ListNode(2);
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(3);
        a0.next=a1;
        a1.next=a2;
        b0.next=b1;
        b1.next=b2;
     */
     /*
        ListNode b0=new ListNode(5);
        ListNode a0=new ListNode(5);
     */

}
