# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head

        def reverseLink(aux: ListNode, curr: ListNode) -> ListNode:
            if curr.next is None:
                curr.next = aux
                return curr
            nextNode = curr.next
            curr.next = aux
            aux = curr
            return reverseLink(aux, nextNode)
        
        temp = head.next
        head.next = None

        return reverseLink(head, temp)