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
        int counter = 0;
        ListNode node = head;

        while (null != node) {
            node = node.next;
            ++counter;
        }

        node = head;

        if (n <= counter) {
            if (1 == counter) {
                return null;
            } else if (0 == counter - n) {
                return head.next;
            }

            while (0 < counter - ++n) {
                node = node.next;
            }

            if (null != node.next) {
                node.next = node.next.next;
            }
        }

        return head;
    }
}
