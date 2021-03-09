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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (1 == d) {
            return new TreeNode(v, root, null);
        }

        Queue<TreeNode> bfs = new LinkedList<TreeNode>();

        if (null != root) {
            bfs.add(root);
            --d;
        }

        while (0 < d-- && !bfs.isEmpty()) {
            int count = bfs.size();

            for (int idx = 0; count > idx; ++idx) {
                TreeNode curr = bfs.poll();

                if (0 == d) {
                    curr.left = new TreeNode(v, curr.left, null);
                    curr.right = new TreeNode(v, null, curr.right);
                } else {
                    if (null != curr.left) {
                        bfs.add(curr.left);
                    }
                    if (null != curr.right) {
                        bfs.add(curr.right);
                    }
                }
            }
        }

        return root;
    }
}
