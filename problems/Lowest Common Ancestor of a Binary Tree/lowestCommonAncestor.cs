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
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;

        dfs(root, p, q, ref res);

        return res;
    }

    private bool dfs(TreeNode node, TreeNode p, TreeNode q, ref TreeNode res) {
        if (null == node) {
            return false;
        }

        var left = dfs(node.left, p, q, ref res) ? 1 : 0;
        var right = dfs(node.right, p, q, ref res) ? 1 : 0;
        var mid = node.val == p.val || node.val == q.val ? 1 : 0;

        if (2 <= left + right + mid) {
            res = node;
        }

        return 0 < left + right + mid;
    }
}
