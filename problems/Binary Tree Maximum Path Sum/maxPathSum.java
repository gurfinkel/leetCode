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

    long result = Integer.MIN_VALUE;

    long dfs(TreeNode note) {
        if (null == note) {
            return 0;
        }

        long leftPath = dfs(note.left);
        long rightPath = dfs(note.right);
        long nodeAndOnePath = Math.max(leftPath + note.val, rightPath + note.val);
        long nodeAndTwoPath = Math.max(note.val, leftPath + note.val + rightPath);

        result = Math.max(result, Math.max(nodeAndOnePath, nodeAndTwoPath));

        return Math.max(note.val, Math.max(leftPath, rightPath) + note.val);
    }
}
