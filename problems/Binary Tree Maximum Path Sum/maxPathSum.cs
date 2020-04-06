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
    public int MaxPathSum(TreeNode root) {
        var result = int.MinValue;

        getMax(root, ref result);

        return result;
    }

    private int getMax(TreeNode node, ref int res) {
        if (null == node) {
            return 0;
        }

        var leftMax = getMax(node.left, ref res);
        var rightMax = getMax(node.right, ref res);

        res = Math.Max(res, node.val + leftMax + rightMax);

        return Math.Max(0, node.val + Math.Max(leftMax, rightMax));
    }
}
