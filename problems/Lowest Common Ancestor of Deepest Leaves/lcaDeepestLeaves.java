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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        List<TreeNode> leaves = new ArrayList<>();

        if (null != root) {
            bfs.add(root);
            leaves.add(root);
        }

        while (!bfs.isEmpty()) {
            int count = bfs.size();
            leaves.clear();

            for (int idx = 0; count > idx; ++idx) {
                TreeNode node = bfs.poll();
                leaves.add(node);

                if (null != node.left) {
                    bfs.add(node.left);
                }

                if (null != node.right) {
                    bfs.add(node.right);
                }
            }
        }

        if (1 == leaves.size()) {
            return leaves.get(0);
        }

        return lowestCommonAncestor(root, leaves.get(0), leaves.get(leaves.size() - 1));
    }

    private TreeNode lca = null;

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);

        return this.lca;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (null == node) {
            return false;
        }

        int left = dfs(node.left, p, q) ? 1 : 0;
        int mid = node.val == p.val || node.val == q.val ? 1 : 0;
        int right = dfs(node.right, p, q) ? 1 : 0;

        if (2 == left + mid + right) {
            this.lca = node;
        }

        return 1 == left + mid + right;
    }
}
