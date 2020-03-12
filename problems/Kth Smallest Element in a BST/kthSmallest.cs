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
    public int KthSmallest(TreeNode root, int k) {
        var nums = inorder(root, new List<int>());
        return nums[k - 1];
    }

    public List<int> inorder(TreeNode root, List<int> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.Add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
