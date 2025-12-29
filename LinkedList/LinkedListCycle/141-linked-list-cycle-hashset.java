import java.util.List;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (!seen.add(curr)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}