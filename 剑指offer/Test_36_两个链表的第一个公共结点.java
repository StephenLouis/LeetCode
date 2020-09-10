/*


 */

public class Test_36_两个链表的第一个公共结点 {
      public class ListNode {
          int val;
         ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          ListNode p1 = headA;
          ListNode p2 = headB;

          while (p1 != p2){
              p1 = p1 == null ? headB : p1.next;
              p2 = p2 == null ? headA : p2.next;
          }
          return p1;
    }
}
