/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        // return ReverseListRecursive(head);
        return ReverseListIterative(head);
    }

    private ListNode ReverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        var curr = head;

        while (null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode ReverseListRecursive(ListNode head) {
        if (null == head || null == head.next) {
            return head; // 2
        }
        // 1 -> 2 -> 3 -> null
        var newTail = head.next; // 3
        var newHead = ReverseList(newTail); // 3

        newTail.next = head; // 3 -> 2
        head.next = null; // 2 -> null

        return newHead; // 3
    }
}
