/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;

        if (0 == n) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        for (int idx = 1; n > idx; ++idx) {
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[idx]);

            while (!stack.isEmpty() && stack.peek().val < child.val) {
                node = stack.pop();
            }

            if (node.val < child.val) {
                node.right = child;
            } else {
                node.left = child;
            }

            stack.push(child);
        }

        return root;
    }
}
