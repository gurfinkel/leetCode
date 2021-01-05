/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> store = new HashMap<>();
        ListNode curr = head;
        ListNode fakeHead = new ListNode();
        ListNode fakeCurr = fakeHead;

        while (null != curr) {
            store.put(curr.val, 1 + store.getOrDefault(curr.val, 0));
            curr = curr.next;
        }

        curr = head;

        while (null != curr) {
            if (1 == store.get(curr.val)) {
                fakeCurr.next = new ListNode(curr.val);
                fakeCurr = fakeCurr.next;
            }

            curr = curr.next;
        }

        return fakeHead.next;
    }
}
