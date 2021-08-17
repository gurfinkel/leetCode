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
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);

        return numGoodNodes;
    }

    private int numGoodNodes = 0;

    private void dfs(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            ++numGoodNodes;
        }

        if (null != node.right) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }

        if (null != node.left) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
    }
}
