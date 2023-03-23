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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();

        if (null != root) {
            bfs.add(root.left);
            bfs.add(root.right);
        }

        while (!bfs.isEmpty()) {
            TreeNode left = bfs.poll();
            TreeNode right = bfs.poll();

            if (null == left && null == right) {
                continue;
            } else if ((null == left && null != right) || (null != left && null == right) || left.val != right.val) {
                return false;
            }

            bfs.add(left.left);
            bfs.add(right.right);
            bfs.add(left.right);
            bfs.add(right.left);
        }

        return true;
    }
}
