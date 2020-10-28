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
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 1);

        return Integer.MAX_VALUE == minDepth ? 0 : minDepth;
    }

    private void dfs(TreeNode node, int depth) {
        if (null == node) {
            return;
        }

        if (null == node.left && null == node.right) {
            minDepth = Math.min(minDepth, depth);
        }

        ++depth;

        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
