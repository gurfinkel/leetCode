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
    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }

        List<Integer> depthList = new ArrayList<>();

        for (Node node : root.children) {
            depthList.add(maxDepth(node));
        }

        return 1 + (0 == depthList.size() ? 0 : Collections.max(depthList));
    }
}
