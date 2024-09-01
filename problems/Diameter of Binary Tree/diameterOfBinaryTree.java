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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] currentAndMaxDepth = new int[] {0, 0};

        dfs(root, currentAndMaxDepth);

        return currentAndMaxDepth[1];
    }

    private int[] dfs(TreeNode node, int[] currentAndMaxDepth) {
        if (null == node) {
            return new int[] {0, currentAndMaxDepth[1]};
        }

        int[] left = dfs(node.left, currentAndMaxDepth);
        int[] right = dfs(node.right, currentAndMaxDepth);

        currentAndMaxDepth[1] = Math.max(currentAndMaxDepth[1], left[0] + right[0]);

        return new int[] {1 + Math.max(left[0], right[0]), currentAndMaxDepth[1]};
    }
}
