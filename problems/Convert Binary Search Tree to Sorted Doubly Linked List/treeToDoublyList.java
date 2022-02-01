/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        Node[] ends = new Node[] {null, null};

        dfs(root, ends);

        ends[1].right = ends[0];
        ends[0].left = ends[1];

        return ends[0];
    }

    public void dfs(Node node, Node[] ends) {
        if (null == node) {
            return;
        }

        dfs(node.left, ends);

        if (null == ends[1]) {
            ends[0] = node;
        } else {
            ends[1].right = node;
            node.left = ends[1];
        }

        ends[1] = node;

        dfs(node.right, ends);
    }
}
