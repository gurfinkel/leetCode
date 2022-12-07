/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (null == head) {
            return null;
        }

        Node fakeHead = new Node(0, null, head, null);

        dfs(fakeHead, head);

        fakeHead.next.prev = null;

        return fakeHead.next;
    }

    public Node dfs(Node prev, Node cur) {
        if (null == cur) {
            return prev;
        }

        cur.prev = prev;
        prev.next = cur;

        Node temp = cur.next;
        Node tail = dfs(cur, cur.child);

        cur.child = null;

        return dfs(tail, temp);
    }
}
