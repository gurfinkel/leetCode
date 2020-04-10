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
    public TreeNode SortedArrayToBST(int[] nums) {
        return getTreeNode(0, nums.Length - 1, nums);
    }

    public TreeNode getTreeNode(int left, int right, int[] nums) {
        if (left > right) return null;

        // always choose left middle node as a root
        var p = (left + right) >> 1;

        // inorder traversal: left -> node -> right
        var node = new TreeNode(nums[p]);

        node.left = getTreeNode(left, p - 1, nums);
        node.right = getTreeNode(p + 1, right, nums);

        return node;
    }
}
