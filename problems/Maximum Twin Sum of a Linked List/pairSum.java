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
    public int pairSum(ListNode head) {
        int result = Integer.MIN_VALUE;
        List<Integer> store = new ArrayList<>();

        while (null != head) {
            store.add(head.val);
            head = head.next;
        }

        for (int idx = 0; store.size() / 2 > idx; ++idx) {
            result = Math.max(result, store.get(idx) + store.get(store.size() - 1 - idx));
        }

        return result;
    }
}
