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

        return this.maxSum;
    }

    private int maxSum = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));
        int newRootSum = node.val + leftSum + rightSum;

        this.maxSum = Math.max(maxSum, newRootSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
