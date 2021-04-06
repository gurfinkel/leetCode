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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(root, result);

        return result;
        // return unWrapDfsStack(root);
    }

    void dfs(TreeNode node, List<Integer> inOrder) {
        if (null == node) {
            return;
        }

        dfs(node.left, inOrder);
        inOrder.add(node.val);
        dfs(node.right, inOrder);
    }

    List<Integer> unWrapDfsStack(TreeNode node) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = node;

        while (null != curr || !stack.isEmpty()) {
            while (null != curr) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            inOrder.add(curr.val);
            curr = curr.right;
        }

        return inOrder;
    }
}
