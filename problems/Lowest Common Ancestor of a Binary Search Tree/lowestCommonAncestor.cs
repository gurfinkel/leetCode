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
        var parentVal = root.val;
        var pVal = p.val;
        var qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return LowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return LowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
