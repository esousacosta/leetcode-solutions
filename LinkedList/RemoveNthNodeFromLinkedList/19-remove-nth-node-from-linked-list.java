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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;

        ListNode curr = head;
        int sz = 0;

        // Getting the size of the linked list
        while (curr != null) {
            curr = curr.next;
            sz++;
        }
        
        // Ex.: 5 - 2 = 3 (0 based index on the list)
        int target = sz - n;

        if (target == 0) {
            head = head.next;
            return head;
        }
        
        int count = 0;
        curr = head;

        // Stop at one node before the one to be removed
        while (count < target - 1) {
            curr = curr.next;
            count++;
        }

        // Bypass the removed node
        curr.next = curr.next.next;

        return head;
    }
}