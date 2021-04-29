/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        dfs(graph, root, null);

        for (TreeNode node: graph.keySet()) {
            if (null != node && k == node.val) {
                bfs.add(node);
                visited.add(node);
            }
        }

        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();

            if (null != node) {
                if (1 >= graph.get(node).size()) {
                    return node.val;
                }

                for (TreeNode nextNode: graph.get(node)) {
                    if (!visited.contains(nextNode)) {
                        bfs.add(nextNode);
                        visited.add(nextNode);
                    }
                }
            }
        }

        return -1;
    }

    public void dfs(HashMap<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (null == node) {
            return;
        }

        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<TreeNode>());
        }
        if (!graph.containsKey(parent)) {
            graph.put(parent, new ArrayList<TreeNode>());
        }

        graph.get(node).add(parent);
        graph.get(parent).add(node);
        dfs(graph, node.left, node);
        dfs(graph, node.right, node);
    }
}
