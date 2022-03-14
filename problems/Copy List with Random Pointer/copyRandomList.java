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
        return copyRandomListRecursive(head);
        // return copyRandomListIterative(head);
    }

    public Node copyRandomListIterative(Node head) {
        if (null == head) {
            return null;
        }

        HashMap<Node, Node> store = new HashMap<>();
        Node node = new Node(head.val);
        Node fakeHead = new Node(-1, node, null);

        store.put(head, node);

        while (null != head) {
            if (null != head.random) {
                if (!store.containsKey(head.random)) {
                    store.put(head.random, new Node(head.random.val, null, null));
                }

                node.random = store.get(head.random);
            }

            if (null != head.next) {
                if (!store.containsKey(head.next)) {
                    store.put(head.next, new Node(head.next.val, null, null));
                }

                node.next = store.get(head.next);
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
        HashMap<Node, Node> store = new HashMap<>();

        store.put(head, newHead);
        newHead.next = dfs(head.next, store);
        newHead.random = dfs(head.random, store);

        return newHead;
    }

    Node dfs(Node node, HashMap<Node, Node> store) {
        if (null == node) {
            return null;
        }

        if (!store.containsKey(node)) {
            Node newNode = new Node(node.val);

            store.put(node, newNode);
            newNode.next = dfs(node.next, store);
            newNode.random = dfs(node.random, store);
        }

        return store.get(node);
    }
}
