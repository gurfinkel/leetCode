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
    public void ReorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }

        var lastNode = head;
        var firstNode = head;
        var secondNode = head;
        ListNode tempNode = null;
        var isEvenStep = false;
        var count = 0;

        while (null != lastNode) {
            lastNode = lastNode.next;

            if (!isEvenStep) {
                firstNode = secondNode;
                secondNode = secondNode.next;

                firstNode.next = tempNode;
                tempNode = firstNode;
            }

            isEvenStep = !isEvenStep;
            ++count;
        }

        ListNode nextNode = null;

        while (null != secondNode) {
            tempNode = secondNode;
            secondNode = secondNode.next;
            lastNode = firstNode;
            firstNode = firstNode.next;

            if (1 == (count&1)) {
                lastNode.next = nextNode;
                tempNode.next = lastNode;
                nextNode = tempNode;
            } else {
                tempNode.next = nextNode;
                lastNode.next = tempNode;
                nextNode = lastNode;
            }
        }

        if (1 == (count&1)) {
            firstNode.next = nextNode;
            head = firstNode;
        } else {
            head = nextNode;
        }
    }
}
