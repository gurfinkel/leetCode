/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        var memory = 0;

        while (null != l1 || null != l2 || 1 == memory) {
            var curr = memory;
            if (null != l1) {
                curr += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                curr += l2.val;
                l2 = l2.next;
            }
            if (null == head) {
                head = new ListNode(curr % 10);
                node = head;
            } else {
                node.next = new ListNode(curr % 10);
                node = node.next;
            }
            memory = curr / 10;
        }

        return head;
    }
}
