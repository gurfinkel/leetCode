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
    public List<Integer> preorder(Node root) {
//         List<Integer> result = new ArrayList<>();

//         dfs(root, result);

//         return result;
        return bfs(root);
    }

    private void dfs(Node node, List<Integer> result) {
        if (null == node) {
            return;
        }

        result.add(node.val);

        for (Node child : node.children) {
            dfs(child, result);
        }
    }

    public List<Integer> bfs(Node node) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();

        if (null == node) {
            return result;
        }

        stack.add(node);

        while (!stack.isEmpty()) {
            Node currNode = stack.pollLast();
            result.add(currNode.val);
            Collections.reverse(currNode.children);

            for (Node item : currNode.children) {
                stack.add(item);
            }
        }

        return result;
    }
}
