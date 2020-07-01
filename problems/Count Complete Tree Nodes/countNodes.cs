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
    public int CountNodes(TreeNode root) {
        int result = 0;

        dfs(root, ref result);

        return result;
    }

    private void dfs(TreeNode node, ref int count) {
        if (null == node) {
            return;
        }

        ++count;

        dfs(node.left, ref count);
        dfs(node.right, ref count);
    }
}
