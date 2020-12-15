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
    public ListNode plusOne(ListNode head) {
        List<ListNode> store = new ArrayList<>();
        ListNode curr = head;
        int memory = 1;

        while (null != curr) {
            store.add(curr);
            curr = curr.next;
        }

        for (int idx = store.size() - 1; 0 <= idx; --idx) {
            store.get(idx).val += memory;
            memory = store.get(idx).val / 10;
            store.get(idx).val = store.get(idx).val % 10;
        }

        if (1 == memory) {
            ListNode temp = head;
            head = new ListNode(memory, temp);
        }

        return head;
    }
}
