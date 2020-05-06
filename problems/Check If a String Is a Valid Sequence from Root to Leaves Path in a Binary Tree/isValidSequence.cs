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
    public bool IsValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr);
    }

    private bool isValid(TreeNode node, int[] arr, int idx = 0) {
        if (null == node || idx >= arr.Length) {
            return false;
        }

        if (null == node.left && null == node.right && arr.Length - 1 == idx && arr[idx] == node.val) {
            return true;
        }

        return arr[idx] == node.val && (isValid(node.left, arr, 1+idx)||isValid(node.right, arr, 1+idx));
    }
}
