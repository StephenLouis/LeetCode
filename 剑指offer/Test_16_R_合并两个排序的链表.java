/*

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Test_16_R_合并两个排序的链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null)
                return list2;
            else if (list2 == null)
                return list1;

                ListNode res = null;
                if (list1.val < list2.val) {
                    res = list1;
                    res.next = Merge(list1.next, list2);
                }else {
                    res = list2;
                    res.next = Merge(list1,list2.next);
                }


            return res;
        }

    }
}
