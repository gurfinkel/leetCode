/*
// Definition for a Node.
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
*/

public class Solution {
    public Node Flatten(Node head) {
        if (null == head) {
            return head;
        }

        var stack = new Stack<Node>();
        var prev = new Node(0);
        var newHead = prev;

        stack.Push(head);

        while (0 < stack.Count) {
            var curr = stack.Pop();
            var next = curr.next;
            var child = curr.child;

            prev.next = curr;
            prev.child = null;
            curr.prev = prev;
            prev = curr;

            if (null != next) {
                stack.Push(next);
            }
            if (null != child) {
                stack.Push(child);
            }
        }

        newHead.next.prev = null;

        return newHead.next;
    }
}
