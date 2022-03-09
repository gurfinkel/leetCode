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
        ListNode fakeHead = new ListNode();
        ListNode node = head;

        while (null != node) {
            store.put(node.val, 1 + store.getOrDefault(node.val, 0));
            node = node.next;
        }

        node = fakeHead;

        while (null != head) {
            if (1 == store.get(head.val)) {
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }

        return fakeHead.next;
    }
}
