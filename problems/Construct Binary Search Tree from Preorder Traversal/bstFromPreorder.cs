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
    public TreeNode BstFromPreorder(int[] preorder) {
        if (null == preorder || 0 == preorder.Length) {
            return null;
        }

        var root = new TreeNode(preorder[0]);
        var stack = new Stack<TreeNode>();

        stack.Push(root);

        for (var i = 1; preorder.Length > i; ++i) {
            var parent = stack.Peek();
            var child = new TreeNode(preorder[i]);

            while (0 < stack.Count && stack.Peek().val < child.val) {
                parent = stack.Pop();
            }

            if (parent.val < child.val) {
                parent.right = child;
            } else {
                parent.left = child;
            }

            stack.Push(child);
        }

        return root;
    }
}
