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
        // return copyRandomListRecursive(head);
        return copyRandomListIterative(head);
    }

    public Node copyRandomListIterative(Node head) {
        if (null == head) {
            return null;
        }

        HashMap<Node, Node> oldNodeToNewNodeMap = new HashMap<>();
        Node node = new Node(head.val);
        Node fakeHead = new Node(-1, node, null);

        oldNodeToNewNodeMap.put(head, node);

        while (null != head) {
            if (null != head.random) {
                if (!oldNodeToNewNodeMap.containsKey(head.random)) {
                    oldNodeToNewNodeMap.put(head.random, new Node(head.random.val, null, null));
                }

                node.random = oldNodeToNewNodeMap.get(head.random);
            }

            if (null != head.next) {
                if (!oldNodeToNewNodeMap.containsKey(head.next)) {
                    oldNodeToNewNodeMap.put(head.next, new Node(head.next.val, null, null));
                }

                node.next = oldNodeToNewNodeMap.get(head.next);
            }

            node = node.next;
            head = head.next;
        }

        return fakeHead.next;
    }

    public Node copyRandomListRecursive(Node head) {
        if (null == head) {
            return null;
        }

        Node newHead = new Node(head.val);
        HashMap<Node, Node> oldNodeToNewNodeMap = new HashMap<>();

        oldNodeToNewNodeMap.put(head, newHead);
        newHead.next = dfs(head.next, oldNodeToNewNodeMap);
        newHead.random = dfs(head.random, oldNodeToNewNodeMap);

        return newHead;
    }

    Node dfs(Node node, HashMap<Node, Node> oldNodeToNewNodeMap) {
        if (null == node) {
            return null;
        }

        if (!oldNodeToNewNodeMap.containsKey(node)) {
            Node newNode = new Node(node.val);

            oldNodeToNewNodeMap.put(node, newNode);
            newNode.next = dfs(node.next, oldNodeToNewNodeMap);
            newNode.random = dfs(node.random, oldNodeToNewNodeMap);
        }

        return oldNodeToNewNodeMap.get(node);
    }
}
