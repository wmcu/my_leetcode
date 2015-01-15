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
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode ret = new ListNode(0);
        ListNode q = ret, p = null;
        int LL = lists.size(), i;
        // initialize pq
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
            public int compare(ListNode l, ListNode r) {
                return l.val - r.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(4, cmp);
        for (i = 0; i < LL; i++) {
            p = lists.get(i);
            if (p != null)
                pq.offer(p);
        }
        // go !
        while (!pq.isEmpty()) {
            p = pq.poll();
            q.next = new ListNode(p.val);
            q = q.next;
            if (p.next != null)
                pq.offer(p.next);
        }
        ret = ret.next;
        return ret;
    }
}