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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);

        while (0 < bfs.size()) {
            var count = bfs.size();
            var cousins = 0;

            for (int i = 0; count > i; ++i) {
                TreeNode node = bfs.poll();

                if (null != node) {
                    if (x == node.val || y == node.val) {
                        ++cousins;
                    }

                    if (null != node.left && null != node.right &&
                       ((x == node.left.val && y == node.right.val) ||
                        (y == node.left.val && x == node.right.val))) {
                        return false;
                    }

                    bfs.offer(node.left);
                    bfs.offer(node.right);
                }

                if (count == 1 + i) {
                    if (1 == cousins) {
                        return false;
                    } else if (2 == cousins) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
