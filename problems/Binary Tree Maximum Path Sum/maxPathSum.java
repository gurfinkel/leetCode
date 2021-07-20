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
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return _maxPath;
    }

    private int _maxPath = Integer.MIN_VALUE;

    private int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int leftPath = Math.max(0, dfs(node.left));
        int rightPath = Math.max(0, dfs(node.right));

        int newPath = node.val + leftPath + rightPath;

        _maxPath = Math.max(_maxPath, newPath);

        return node.val + Math.max(leftPath, rightPath);
    }
}
