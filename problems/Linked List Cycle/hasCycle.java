/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // return hasCycleWithHashSet(head);
        return hasCycleByFloyd(head);
    }

    public boolean hasCycleWithHashSet(ListNode head) {
        HashSet<ListNode> store = new HashSet<>();

        while (null != head) {
            if (store.contains(head)) {
                return true;
            }

            store.add(head);
            head = head.next;
        }

        return false;
    }

    public boolean hasCycleByFloyd(ListNode head) {
        // Floyd's Cycle Finding Algorithm
        if (null == head) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
