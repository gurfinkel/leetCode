/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }

        TreeNode lca = new TreeNode(root.val);

        dfs(root, p, q, lca);

        return lca;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q, TreeNode lca) {
        if (null == node) {
            return false;
        }

        int left = dfs(node.left, p, q, lca) ? 1 : 0;
        int mid = node.val == p.val || node.val == q.val ? 1 : 0;
        int right = dfs(node.right, p, q, lca) ? 1 : 0;

        if (2 == left + mid + right) {
            lca.val = node.val;
        }

        return 1 == left + mid + right;
    }
}
