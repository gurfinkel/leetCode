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
    public TreeNode IncreasingBST(TreeNode root) {
        TreeNode fakeRoot = new TreeNode();

        curr = fakeRoot;
        inOrderWithRelinking(root);

        return fakeRoot.right;
    }

    private TreeNode curr;

    private void inOrderWithRelinking(TreeNode node) {
        if (null == node) {
            return;
        }

        inOrderWithRelinking(node.left);

        node.left = null;
        curr.right = node;
        curr = node;

        inOrderWithRelinking(node.right);
    }
}
