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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }

        if (null == root2) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;

        // return unWrapDfsStack(root1, root2);
    }

    TreeNode unWrapDfsStack(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }

        Stack<TreeNode[]> stack = new Stack<>();

        stack.push(new TreeNode[] {root1, root2});

        while (!stack.isEmpty()) {
            TreeNode[] node = stack.pop();

            if (null == node[0] || null == node[1]) {
                continue;
            }

            node[0].val += node[1].val;

            if (null == node[0].left) {
                node[0].left = node[1].left;
            } else {
                stack.push(new TreeNode[] {node[0].left, node[1].left});
            }

            if (null == node[0].right) {
                node[0].right = node[1].right;
            } else {
                stack.push(new TreeNode[] {node[0].right, node[1].right});
            }
        }

        return root1;
    }
}
