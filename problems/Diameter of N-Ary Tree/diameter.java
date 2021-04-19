/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        int[] result = new int[] {0};

        dfs (root, result);

        return result[0];
    }

    private int dfs(Node node, int[] diameter) {
        int maxHeight1 = 0;
        int maxHeight2 = 0;

        for (Node child : node.children) {
            int parentHeight = dfs(child, diameter);

            if (parentHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            } else if (parentHeight > maxHeight2) {
                maxHeight2 = parentHeight;
            }

            diameter[0] = Math.max(diameter[0], maxHeight1 + maxHeight2);
        }

        return 1 + maxHeight1;
    }
}
