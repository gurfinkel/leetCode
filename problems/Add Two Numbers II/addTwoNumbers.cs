/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }

        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

//         var last1 = l1;
//         var last2 = l2;
//         var num1 = new Stack<int>();
//         var num2 = new Stack<int>();

//         while (null != last1 || null != last2) {
//             if (null != last1) {
//                 num1.Push(last1.val);
//                 last1 = last1.next;
//             }
//             if (null != last2) {
//                 num2.Push(last2.val);
//                 last2 = last2.next;
//             }
//         }

//         var stack = new Stack<int>();
//         var memory = 0;

//         while (0 != num1.Count || 0 != num2.Count || 0 != memory) {
//             var digit = memory;
//             if (0 != num1.Count) {
//                 digit += num1.Pop();
//             }
//             if (0 != num2.Count) {
//                 digit += num2.Pop();
//             }
//             stack.Push(digit % 10);
//             memory = digit / 10;
//         }

//         var head = new ListNode(stack.Pop());
//         var curr = head;
//         while (0 != stack.Count) {
//             curr.next = new ListNode(stack.Pop());
//             curr = curr.next;
//         }

//         return head;

        var reversed1 = reverseList(l1);
        var reversed2 = reverseList(l2);
        var memory = (reversed1.val + reversed2.val) / 10;
        var head = new ListNode((reversed1.val + reversed2.val) % 10);
        var curr = head;

        reversed1 = reversed1.next;
        reversed2 = reversed2.next;

        while (null != reversed1 || null != reversed2 || 0 != memory) {
            var digit = memory;
            if (null != reversed1) {
                digit += reversed1.val;
                reversed1 = reversed1.next;
            }
            if (null != reversed2) {
                digit += reversed2.val;
                reversed2 = reversed2.next;
            }
            curr.next = new ListNode(digit % 10);
            memory = digit / 10;
            curr = curr.next;
        }

        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        var node = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }
}
