# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        
        curr = head.next
        head.next = None
        aux = head

        while curr.next is not None:
            nextNode = curr.next
            curr.next = aux
            aux = curr
            curr = nextNode

        curr.next = aux
        return curr