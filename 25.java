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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nh = new ListNode(0); // new head
        nh.next = head;
        ListNode[] buf = new ListNode[k];
        ListNode p, q, s, t;
        int i, j;
        q = nh;
        p = q.next;
        while (p != null) {
            // p - first node of current k-group
            // q - last node before current k-group
            for (i = 0; p != null && i < k; i++) {
                buf[i] = p;
                p = p.next;
            }
            if (i < k) // left less than k nodes
                break;
            for (j = 0; j < k; j++) { // swap
                q.next = buf[k - j - 1];
                q = q.next;
            }
            q.next = p;
        }
        return nh.next;
    }
}