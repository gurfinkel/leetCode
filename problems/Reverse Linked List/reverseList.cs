/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
//         ListNode prev = null;
//         ListNode next = null;
//         var curr = head;

//         while (null != curr) {
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         return prev;

        if (null == head || null == head.next) {
            return head;
        }

        var node = ReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}
