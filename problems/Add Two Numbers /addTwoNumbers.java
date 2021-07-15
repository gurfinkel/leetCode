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
        ListNode fakeHead = new ListNode();
        ListNode curr = fakeHead;
        int carry = 0;

        while (null != l1 || null != l2 || 0 != carry) {
            int sum = carry;

            if (null != l1) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (null != l2) {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
        }

        return fakeHead.next;
    }
}
