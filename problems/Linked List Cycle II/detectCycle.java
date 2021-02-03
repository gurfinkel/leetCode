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
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> store = new HashSet<>();

        while (null != head) {
            if (store.contains(head)) {
                return head;
            }

            store.add(head);
            head = head.next;
        }

        return null;
    }
}
