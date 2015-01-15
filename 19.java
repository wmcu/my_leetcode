/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, cur_n = head, cur_n_1 = head;
        int t = 1;
        for (cur = head; cur != null; t++) {
            if (t == n + 1)
                cur_n = head;
            if (t > n + 1)
                cur_n = cur_n.next;
            cur = cur.next;
        }
        if (n + 1 == t) { // remove head
            cur = head.next;
            head = cur;
        } else { // remove node in middle
            cur_n_1 = cur_n.next;
            cur_n.next = cur_n_1.next;
        }
        return head;
    }
}