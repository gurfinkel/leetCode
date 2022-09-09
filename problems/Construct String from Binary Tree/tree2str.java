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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        HashSet<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        if (null != root) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (visited.contains(node)) {
                stack.pop();
                sb.append(")");
            } else {
                visited.add(node);
                sb.append("(" + node.val);

                if (null == node.left && null != node.right) {
                    sb.append("()");
                }
                if (null != node.right) {
                    stack.push(node.right);
                }
                if (null != node.left) {
                    stack.push(node.left);
                }
            }
        }
        return 0 == sb.length() ? "" : sb.substring(1, sb.length() - 1);
    }
}
