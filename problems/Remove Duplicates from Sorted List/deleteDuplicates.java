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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;

        while (null != curr) {
            curr = curr.next;
            prev.next = null;

            if (null != curr && prev.val != curr.val) {
                prev.next = new ListNode(curr.val);
                prev = prev.next;
            }
        }

        return head;
    }
}
