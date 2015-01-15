public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        int tmp = 0;
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        ListNode pre = ret;
        while (l1 != null && l2 != null) {
            tmp = l1.val + l2.val + flag;
            p.val = tmp % 10;
            flag = tmp / 10;
            p.next = new ListNode(0);
            pre = p;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            tmp = l1.val + flag;
            p.val = tmp % 10;
            flag = tmp / 10;
            p.next = new ListNode(0);
            pre = p;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tmp = l2.val + flag;
            p.val = tmp % 10;
            flag = tmp / 10;
            p.next = new ListNode(0);
            pre = p;
            p = p.next;
            l2 = l2.next;
        }
        if (flag != 0)
            p.val = flag;
        else
            pre.next = null;
        return ret;
    }
}