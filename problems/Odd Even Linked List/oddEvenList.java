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
    public ListNode oddEvenList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        ListNode fakeTail = new ListNode(0);
        ListNode oddNode = fakeHead;
        ListNode evenNode = fakeTail;
        ListNode node = head;
        int idx = 1;

        while (null != node) {
            if (1 == (idx&1)) {
                oddNode.next = node;
                oddNode = oddNode.next;
            } else {
                evenNode.next = node;
                evenNode = evenNode.next;
            }
            node = node.next;
            ++idx;
        }

        evenNode.next = null;
        oddNode.next = fakeTail.next;

        return fakeHead.next;
    }
}
