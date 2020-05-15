/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode ReverseBetween(ListNode head, int m, int n) {
        if (n == m) {
            return head;
        }

        var curr = head;

        while (0 < --n) {
            curr = curr.next;
        }

        var tail = curr.next;
        curr.next = null;

        var headToReverse = head;

        if (1 != m) {
            curr = head;
            --m;

            while (0 < --m) {
                curr = curr.next;
            }

            headToReverse = curr.next;
            curr.next = null;
        }

        var reversedPart = ReverseList(headToReverse);

        if (null != tail) {
            curr = reversedPart;

            while (null != curr.next) {
                curr = curr.next;
            }

            curr.next = tail;
        }

        if (1 == m) {
            head = reversedPart;
        } else {
            curr = head;

            while (null != curr.next) {
                curr = curr.next;
            }

            curr.next = reversedPart;
        }

        return head;
    }

    private ListNode ReverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode node = ReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}
