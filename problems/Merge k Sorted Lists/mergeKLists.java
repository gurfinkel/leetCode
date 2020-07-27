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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode> (
            (a, b) -> a.val - b.val
        );
        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;

        for (ListNode listHead : lists) {
            if (null != listHead) {
                minHeap.offer(listHead);
            }
        }

        while(!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();

            if (null != curr.next) {
                minHeap.offer(curr.next);
            }

            node.next = curr;
            node = node.next;
        }

        return dummyHead.next;
    }
}
