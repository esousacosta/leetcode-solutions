# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return False
        aux = head
        seen = set()
        while aux.next is not None:
            if aux in seen:
                return True
            seen.add(aux)
            aux = aux.next
        return False