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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();

        if (null != root) {
            bfs.add(root);
        }

        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();

            if (null == node.left && null != node.right) {
                result.add(node.right.val);
            }

            if (null != node.left && null == node.right) {
                result.add(node.left.val);
            }

            if (null != node.left) {
                bfs.add(node.left);
            }

            if (null != node.right) {
                bfs.add(node.right);
            }
        }

        return result;
    }
}
