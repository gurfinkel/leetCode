/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int Depth(TreeNode node, ref int depth) {
        if (null == node) {
            return 0;
        }

        var left = Depth(node.left, ref depth);
        var right = Depth(node.right, ref depth);

        depth = Math.Max(depth, 1 + left + right);

        return 1 + Math.Max(left, right);
    }
    public int DiameterOfBinaryTree(TreeNode root) {
        int depth = 1;

        Depth(root, ref depth);

        return depth - 1;
    }
}
