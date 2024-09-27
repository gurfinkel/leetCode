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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        int level = 0;

        if (null != root) {
            bfs.add(root);
        }

        while (!bfs.isEmpty()) {
            TreeNode prevNode = null;

            for (int idx = bfs.size(); 0 < idx; --idx) {
                TreeNode node = bfs.poll();

                if (null != node.left) {
                    bfs.add(node.left);
                }

                if (null != node.right) {
                    bfs.add(node.right);
                }

                if ((1 == (level % 2) && 1 == (node.val % 2)) || (0 == (level % 2) && 0 == (node.val % 2))) {
                    return false;
                }

                if (null != prevNode && ((1 == (level % 2) && prevNode.val <= node.val) || (0 == (level % 2) && prevNode.val >= node.val))) {
                    return false;
                }

                prevNode = node;
            }

            ++level;
        }

        return true;
    }
}
