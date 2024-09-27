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
    public int largestBSTSubtree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return getNodeCount(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBst(TreeNode node, int minValue, int maxValue) {
        if (null == node) {
            return true;
        }

        if (minValue >= node.val || maxValue <= node.val) {
            return false;
        }

        return isBst(node.left, minValue, node.val) && isBst(node.right, node.val, maxValue);
    }

    private int getNodeCount(TreeNode node) {
        if (null == node) {
            return 0;
        }

        return 1 + getNodeCount(node.left) + getNodeCount(node.right);
    }
}
