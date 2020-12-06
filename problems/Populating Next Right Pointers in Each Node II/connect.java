/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> bfs = new LinkedList<>();

        if (null != root) {
            bfs.offer(root);
        }

        while (!bfs.isEmpty()) {
            int count = bfs.size();

            for (int idx = 0; count > idx; ++idx) {
                Node curr = bfs.poll();

                curr.next = count - 1 == idx ? null : bfs.peek();

                if (null != curr.left) {
                    bfs.offer(curr.left);
                }

                if (null != curr.right) {
                    bfs.offer(curr.right);
                }
            }
        }

        return root;
    }
}
