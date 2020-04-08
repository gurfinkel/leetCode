/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode MiddleNode(ListNode head) {
        var counter = 0;
        var first = head;
        var second = head;

        while (null != first) {
            if (1 == (counter & 1)) {
                second = second.next;
            }

            first = first.next;
            ++counter;
        }

        return second;
    }
}
