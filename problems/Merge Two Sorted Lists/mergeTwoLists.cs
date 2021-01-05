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
    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode();
        ListNode curr = fakeHead;

        while (null != l1 || null != l2) {
            if (null == l1) {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (null == l2) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }

            curr = curr.next;
        }

        return fakeHead.next;
    }
}
