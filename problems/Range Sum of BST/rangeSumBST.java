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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        Queue<TreeNode> bfs = new LinkedList<>();

        if (null != root) {
            bfs.add(root);
        }

        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();

            if (low <= node.val && high >= node.val) {
                result += node.val;
            }

            if (null != node.left && low < node.val) {
                bfs.add(node.left);
            }

            if (null != node.right && high > node.val) {
                bfs.add(node.right);
            }
        }

        return result;
    }
}
