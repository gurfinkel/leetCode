/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        Queue<Node> bfs = new LinkedList<Node>();

        if (null != root) {
            bfs.add(root);
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            List<Integer> level = new ArrayList();

            for (int idx = 0; size > idx; ++idx) {
                Node node = bfs.poll();

                level.add(node.val);

                for (Node child : node.children) {
                    bfs.add(child);
                }
            }

            result.add(level);
        }

        return result;
    }
}
