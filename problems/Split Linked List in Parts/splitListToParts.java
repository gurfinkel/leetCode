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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode node = head;
        int length = 0;

        while (null != node) {
            node = node.next;
            ++length;
        }

        int width = length / k;
        int rem = length % k;
        
        node = head;

        for (int idx = 0; k > idx; ++idx) {
            ListNode newHead = node;

            for (int j = 0; width + (rem > idx ? 1 : 0)  - 1 > j; ++j) {
                if (node != null) {
                    node = node.next;
                }
            }

            if (null != node) {
                ListNode prev = node;

                node = node.next;
                prev.next = null;
            }

            result[idx] = newHead;
        }

        return result;
    }
}
