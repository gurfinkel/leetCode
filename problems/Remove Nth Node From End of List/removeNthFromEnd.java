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
        ListNode fakeHead = new ListNode();
        ListNode firstNode = fakeHead;
        ListNode secondNode = fakeHead;

        fakeHead.next = head;

        for (int idx = 0; n >= idx; ++idx) {
            firstNode = firstNode.next;
        }

        while (null != firstNode) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        secondNode.next = secondNode.next.next;

        return fakeHead.next;
    }
}
