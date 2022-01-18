/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        if (visitedHash.containsKey(head)) {
          return visitedHash.get(head);
        }

        Node node = new Node(head.val, null, null);

        visitedHash.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    private HashMap<Node, Node> visitedHash = new HashMap<>();
}
