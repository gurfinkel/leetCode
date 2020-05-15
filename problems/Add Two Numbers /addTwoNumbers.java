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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int memory = 0;

        while (null != l1 || null != l2 || 1 == memory) {
            int num = memory;

            if (null != l1) {
                num += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                num += l2.val;
                l2 = l2.next;
            }
            if (null == head) {
                head = new ListNode(num % 10);
                curr = head;
            } else {
                curr.next = new ListNode(num % 10);
                curr = curr.next;
            }

            memory = num / 10;
        }

        return head;
    }
}
