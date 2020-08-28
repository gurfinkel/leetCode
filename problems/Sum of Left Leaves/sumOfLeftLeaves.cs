/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int SumOfLeftLeaves(TreeNode root) {
        int result = 0;

        addValue(root, ref result);

        return result;
    }

    private void addValue(TreeNode node, ref int result) {
        if (null == node) {
            return;
        }

        if (null != node.left && null == node.left.left && null == node.left.right) {
            result += node.left.val;
        }

        addValue(node.left, ref result);
        addValue(node.right, ref result);
    }
}
