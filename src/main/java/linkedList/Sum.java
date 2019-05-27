package linkedList;

public class Sum {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answ = null;
        ListNode answEnd = null;
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
            } else if (l2 == null) {
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
            carry = localSum / 10;  // careful
            localSum = localSum - 10 < 0 ? localSum : localSum - 10;

            // insert answer at END of answer
            ListNode tmp = new ListNode(localSum);
            if (answ == null) {
                answ = tmp;
                answEnd = tmp;
            } else {
                answEnd.next = tmp;
                answEnd = tmp;
            }
        }
        return answ;
    }
    /*
    l1: 0
    l2: 3-4-5

    */
    /**
     * Definition for singly-linked list.
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     */
    public static void main(String a[]){
        Sum s = new Sum();
        ListNode b0=new ListNode(5);
        ListNode b1=new ListNode(6);
        ListNode b2=new ListNode(4);
        ListNode a0=new ListNode(2);
//        ListNode a1=new ListNode(4);
//        ListNode a2=new ListNode(3);
        a0.next=null;//a1;
        //a1.next=a2;
        b0.next=b1;
        b1.next=b2;
        final ListNode aa = s.addTwoNumbers(a0, b0);

        for (ListNode y =aa; y != null; y=y.next)
             System.out.print(y.val+" ");
        System.out.println();
    }


}
