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
    public boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (null == root) {
            return true;
        }

        // Check if subtrees have height within 1.
        // If they do, check if the subtrees are balanced.
        return 2 > Math.abs(height(root.left) - height(root.right)) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        // An empty tree has height -1
        if (null == root) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
};
