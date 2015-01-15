# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def reverseKGroup(self, head, k):
        nh = ListNode(0) # new head
        nh.next = head
        buf = [head] * k
        q, p = nh, nh.next
        while p is not None:
            # p - first node of current k-group
            # q - last node before current k-group
            for i in range(k):
                if p is None: break
                buf[i] = p
                p = p.next
            else:
                for j in range(k):
                    q.next = buf[k - 1 - j]
                    q = q.next
                q.next = p
            # less than k nodes left
            # break
        return nh.next