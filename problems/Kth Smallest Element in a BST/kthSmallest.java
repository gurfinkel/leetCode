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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> bfs = new Stack<>();

        while (true) {
            while (null != root) {
                bfs.push(root);
                root = root.left;
            }

            root = bfs.pop();

            if (0 == --k) {
                return root.val;
            }

            root = root.right;
        }
    }
}
