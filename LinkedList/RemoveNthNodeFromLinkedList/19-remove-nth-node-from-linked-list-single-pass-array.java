import java.util.List;
import java.util.ArrayList;

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
        List<ListNode> cache = new ArrayList<>();

        // Getting the size of the linked list
        while (curr != null) {
            cache.add(curr);
            curr = curr.next;
        }

        int size = cache.size();
        
        // Ex.: 5 - 2 = 3 (0 based index on the list)
        int target = size - n;

        if (target == 0) {
            head = head.next;
            return head;
        }

        if (target == size - 1) {
            cache.get(size - 2).next = null;
            return head;
        }

        // Bypass the removed node
        cache.get(target - 1).next = cache.get(target + 1);

        return head;
    }
}