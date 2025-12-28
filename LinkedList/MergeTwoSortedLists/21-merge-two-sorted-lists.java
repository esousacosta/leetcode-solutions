/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        ListNode head = null;
        ListNode tip = null;

        if (list1.val <= list2.val) {
            head = list1;
            tip = head;
            list1 = list1.next;
            if (list1 == null) {
                head.next = list2;
                return head;
            }
        } else {
            head = list2;
            tip = head;
            list2 = list2.next;
            if (list2 == null) {
                head.next = list1;
                return head;
            }
        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (head.next == null) {
                    head.next = list1;
                }

                tip.next = list1;
                tip = tip.next;
                list1 = list1.next;

                if (list1 == null) {
                    tip.next = list2;
                    return head;
                }
            } else {
                if (head.next == null) {
                    head.next = list2;
                }

                tip.next = list2;
                tip = tip.next;
                list2 = list2.next;

                if (list2 == null) {
                    tip.next = list1;
                    return head;
                }
            }
        }

        return head;
    }
}