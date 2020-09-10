/*
输入一个链表，输出该链表中倒数第k个结点。
 */

public class Test_14_R_链表中倒数第k个结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p1, p2;
        p1 = p2 = head;
        int i = 0;

        for (;p1 != null;i++){
            p1 = p1.next;
            //p1要领p2 k 步，第k步一起走
            if (i >= k)
                p2 = p2.next;
        }
        return i < k ? null : p2;
    }
}
