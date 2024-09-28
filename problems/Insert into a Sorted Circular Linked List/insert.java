/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        
        if (null == head) {
            node.next = node;

            return node;
        }

        Node prev = head;
        Node next = head.next;

        while (next != head) {
            if ((insertVal >= prev.val && insertVal < next.val)
                || (insertVal >= prev.val && prev.val > next.val)
                || (insertVal <= next.val && prev.val > next.val)) {
                break;
            }
            prev = next;
            next = next.next;
        }

        prev.next = node;
        node.next = next;

        return head;
    }
}
