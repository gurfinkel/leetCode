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
    public void flatten(TreeNode root) {
        bfs(root);
    }

    private void bfs(TreeNode node) {
        if (null == node) {
            return;
        }

        while (null != node) {
            if (null != node.left) {
                TreeNode rightmost = node.left;

                while (null != rightmost.right) {
                    rightmost = rightmost.right;
                }

                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            node = node.right;
        }
    }

    private TreeNode dfs(TreeNode node) {
        if (null == node) {
            return null;
        }

        if (null == node.left && null == node.right) {
            return node;
        }

        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        if (null != leftTail) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return null == rightTail ? leftTail : rightTail;
    }
}
