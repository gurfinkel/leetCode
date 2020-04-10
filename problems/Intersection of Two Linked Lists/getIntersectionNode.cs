/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        var store = new HashSet<ListNode>();

        while (null != headA || null != headB) {
            if (null != headA) {
                if (store.Contains(headA)) {
                    return headA;
                } else {
                    store.Add(headA);
                    headA = headA.next;
                }
            }

            if (null != headB) {
                if (store.Contains(headB)) {
                    return headB;
                } else {
                    store.Add(headB);
                    headB = headB.next;
                }
            }
        }

        return null;
    }
}
