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
    public TreeNode LcaDeepestLeaves(TreeNode root) {
        var (node, _)  = lca(root, 0);
        return node;
    }

    public (TreeNode, int) lca(TreeNode root, int depth) {
        if (null == root || (null == root.left && null == root.right)) {
            return (root, depth);
        }

        (TreeNode left, int leftDepth) = lca(root.left, 1 + depth);
        (TreeNode right, int rightDepth) = lca(root.right, 1 + depth);

        if (null == left && null == right) {
            return (root, depth);
        }

        if (null == right || (leftDepth > rightDepth)) {
            return (left, leftDepth);
        }

        if (null == left || (rightDepth > leftDepth)) {
            return (right, rightDepth);
        }

        return (root, leftDepth);
    }
}
