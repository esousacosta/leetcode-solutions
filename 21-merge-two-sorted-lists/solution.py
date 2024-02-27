# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None and list2 is None:
            return None
        elif list2 is None:
            return list1
        elif list1 is None:
            return list2

        
        mergedHead: ListNode = None
        if list1.val <= list2.val:
            mergedHead = list1
            list1 = list1.next
        else:
            mergedHead = list2
            list2 = list2.next

        final: ListNode = mergedHead

        while (list1 is not None) or (list2 is not None):
            if list1 is None:
                final.next = list2
                return mergedHead
            if list2 is None:
                final.next = list1
                return mergedHead
            
            if list1.val <= list2.val:
                final.next = list1
                final = final.next
                list1 = list1.next
            else:
                final.next = list2
                final = final.next
                list2 = list2.next

        return mergedHead