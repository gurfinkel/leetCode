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

        return (int)result;
    }

    private long result = Integer.MIN_VALUE;

    private int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int leftPathSum = dfs(node.left);
        int rightPathSum = dfs(node.right);
        int maxNodeAndOnePathSum = node.val + Math.max(leftPathSum, rightPathSum);
        int maxNodeAndTwoPathSum = Math.max(node.val, leftPathSum + node.val + rightPathSum);

        result = Math.max(result, Math.max(maxNodeAndOnePathSum, maxNodeAndTwoPathSum));

        return Math.max(node.val, maxNodeAndOnePathSum);
    }
}
