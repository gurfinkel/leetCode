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
    public int GetDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        int result = 0;

        while (null != head) {
            sb.Insert(0, head.val.ToString());
            head = head.next;
        }

        for (int idx = 0; sb.Length > idx; ++idx) {
            result += ('1' == sb[idx] ? 1 : 0) * (1 << idx);
        }

        return result;
    }
}
