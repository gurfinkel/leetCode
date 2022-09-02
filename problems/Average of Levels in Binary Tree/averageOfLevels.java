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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();

        if (null != root) {
            bfs.add(root);
        }

        while (!bfs.isEmpty()) {
            double sum = 0;
            int count = bfs.size();

            for (int idx = bfs.size(); 0 < idx; --idx) {
                TreeNode node = bfs.poll();

                sum += node.val;
                if (null != node.left) {
                    bfs.add(node.left);
                }
                if (null != node.right) {
                    bfs.add(node.right);
                }
            }

            result.add(sum / count);
        }

        return result;
    }
}
