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
        // return mergeKListsWithHeap(lists);
        return mergeKListsByTwo(lists);
    }

    public ListNode mergeKListsWithHeap(ListNode[] lists) {
        ListNode fakeHead = new ListNode();
        ListNode node = fakeHead;
        PriorityQueue<ListNode> store = new PriorityQueue<>((a,b)->a.val-b.val);

        for (ListNode list : lists) {
            if (null != list) {
                store.add(list);
            }
        }

        while (!store.isEmpty()) {
            ListNode list = store.poll();

            node.next = new ListNode(list.val);
            node = node.next;

            list = list.next;

            if (null != list) {
                store.add(list);
            }
        }

        return fakeHead.next;
    }

    public ListNode mergeKListsByTwo(ListNode[] lists) {
        for (int idx = 1; lists.length > idx; ++idx) {
            lists[0] = mergeTwoLists(lists[0], lists[idx]);
        }

        return null == lists || 0 == lists.length ? null : lists[0];
    }

    ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode fakeHead = new ListNode();
        ListNode node = fakeHead;

        while (null != a || null != b) {
            if (null == a) {
                node.next = new ListNode(b.val);
                b = b.next;
            } else if (null == b) {
                node.next = new ListNode(a.val);
                a = a.next;
            } else {
                if (a.val < b.val) {
                    node.next = new ListNode(a.val);
                    a = a.next;
                } else {
                    node.next = new ListNode(b.val);
                    b = b.next;
                }
            }
            node = node.next;
        }

        return fakeHead.next;
    }
}
