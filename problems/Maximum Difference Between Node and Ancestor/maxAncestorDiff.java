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
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val);

        return result;
    }

    int result = 0;

    int dfs(TreeNode root, int minVal) {
        if (null == root) {
            return minVal;
        }

        minVal = Math.min(minVal, root.val);
        int minLeft = dfs(root.left, minVal);
        int minRight = dfs(root.right, minVal);

        result = Math.max(result, Math.max(Math.abs(root.val - minLeft), Math.abs(root.val - minRight)));

        return Math.min(minLeft, minRight);
    }
}
