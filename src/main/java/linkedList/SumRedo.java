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

public class SumRedo {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answ = null;
        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode endAnsw = null;

        int v1, v2;
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
                // inc both
                v1 = cur1.val;
                cur1 = cur1.next;
                v2 = cur2.val;
                cur2 = cur2.next;
            }

            int localSum = v1 + v2 + carry;
            carry = localSum / 10;
            localSum = localSum % 10;
            ListNode newnode = new ListNode(localSum);
            if (answ == null) {
                answ = newnode;
                endAnsw = newnode;
            } else {
                endAnsw.next=newnode;
                endAnsw = newnode;
            }
        }
        return answ;
    }
    /**
     * Definition for singly-linked list.
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     */
    public static void main(String a[]){
        SumRedo s = new SumRedo();
        ListNode b0=new ListNode(5);
        ListNode a0=new ListNode(5);

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
