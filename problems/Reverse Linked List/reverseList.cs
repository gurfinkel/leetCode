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
            return head;
        }
        // 4 -> 5 -> null
        var newTail = head.next; // 5
        var newHead = ReverseList(newTail); // 5

        newTail.next = head; // 5 -> 4
        head.next = null; // 4 -> null

        return newHead; // 5
    }
}
