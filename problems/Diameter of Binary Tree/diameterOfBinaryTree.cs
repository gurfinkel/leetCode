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
    public int DiameterOfBinaryTree(TreeNode root) {
        var result = 0;

        getDepth(root, ref result);

        return result;
    }

    private int getDepth(TreeNode node, ref int depth) {
        if (null == node) {
            return 0;
        }

        var l = getDepth(node.left, ref depth);
        var r = getDepth(node.right, ref depth);

        depth = Math.Max(depth, l + r);

        return 1 + Math.Max(l, r);
    }
}
