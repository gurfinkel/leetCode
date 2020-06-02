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
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        var stack1 = new Stack<int>();
        var stack2 = new Stack<int>();

        while (null != l1 || null != l2) {
            if (l1 != null) {
                stack1.Push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.Push(l2.val);
                l2 = l2.next;
            }
        }

        ListNode head = null;
        ListNode curr = null;
        ListNode newHead = null;
        var carry = 0;

        while (0 < stack1.Count || 0 < stack2.Count || 1 == carry) {
            var digit1 = 0 == stack1.Count ? 0 : stack1.Pop();
            var digit2 = 0 == stack2.Count ? 0 : stack2.Pop();
            var sum = carry + digit1 + digit2;

            if (null == head) {
                head = new ListNode(sum % 10);
                curr = head;
            } else {
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }

            newHead = new ListNode(curr.val, newHead);

            carry = sum / 10;
        }

        return newHead;
    }
}
