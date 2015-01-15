# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        cur, cur_n = head, head
        t = 1
        while cur != None:
            if t == n + 1: cur_n = head
            if t > n + 1: cur_n = cur_n.next
            cur = cur.next
            t += 1
        if n + 1 == t: #remove head
            cur = head.next
            head = cur
        else:
            cur_n_1 = cur_n.next
            cur_n.next = cur_n_1.next
        return head