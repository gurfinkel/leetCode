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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> bfs = new LinkedList<>();

        if (null != bfs) {
            bfs.offer(root);
        }

        while (!bfs.isEmpty()) {
            int count = bfs.size();

            for (int idx = 1; count >= idx; ++idx) {
                TreeNode curr = bfs.poll();

                if (curr.val == u.val) {
                    return count == idx ? null : bfs.poll();
                }

                if (null != curr.left) {
                    bfs.offer(curr.left);
                }

                if (null != curr.right) {
                    bfs.offer(curr.right);
                }
            }
        }

        return null;
    }
}
