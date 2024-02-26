# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Invert the linked list, and if the last seen node is
# the original head, it means we have a cycle
class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:

        def rec(prev, curr):
            if curr.next is None:
                return curr
            nextNode = curr.next
            curr.next = prev
            prev = curr
            return rec(prev, nextNode)
        
        if head is None or head.next is None:
            return False

        curr = head.next
        head.next = None

        lastNode = rec(head, curr)

        if lastNode == head:
            return True

        return False