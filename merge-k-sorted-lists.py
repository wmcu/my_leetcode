# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        ret = ListNode(0)
        q = ret
        LL = len(lists)
        hq = []
        # headqueue initialize
        for i in range(LL):
            p = lists[i]
            if p != None:
                #p.val = -p.val
                heapq.heappush(hq, (p.val, p))
        # go!
        while len(hq) > 0:
            _, p = heapq.heappop(hq)
            #p.val = -p.val
            q.next = p
            q = q.next
            if p.next != None:
                p = p.next
                #p.val = -p.val
                heapq.heappush(hq, (p.val, p))
        return ret.next