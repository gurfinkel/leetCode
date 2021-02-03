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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> store = new PriorityQueue<>();
        ListNode fakeHead = new ListNode();
        ListNode currNode = fakeHead;

        for (ListNode head : lists) {
            while (null != head) {
                store.add(head.val);
                head = head.next;
            }
        }

        while (!store.isEmpty()) {
            currNode.next = new ListNode(store.poll());
            currNode = currNode.next;
        }

        return fakeHead.next;
    }
}
