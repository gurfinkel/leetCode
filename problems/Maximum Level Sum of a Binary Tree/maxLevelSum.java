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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 0;
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();

        if (null != root) {
            bfs.add(root);
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            int sum = 0;

            ++level;

            for (int idx = 0; size > idx; ++idx) {
                TreeNode node = bfs.poll();

                sum += node.val;

                if (null != node.left) {
                    bfs.add(node.left);
                }

                if (null != node.right) {
                    bfs.add(node.right);
                }
            }

            if (maxSum < sum) {
                maxSum = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}
