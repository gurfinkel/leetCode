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
    public int ClosestValue(TreeNode root, double target) {
        var stack = new Stack<TreeNode>();
        int? prev = null;

        while (0 < stack.Count || null != root) {
            while (null != root) {
                stack.Push(root);
                root = root.left;
            }

            var curr = stack.Pop();

            if (prev.HasValue && target >= prev.Value && target < curr.val) {
                return Math.Abs(target - prev.Value) < Math.Abs(target - curr.val) ? prev.Value : curr.val;
            } else if (target < curr.val) {
                return curr.val;
            }

            prev = curr.val;
            root = curr.right;
        }

        return prev.Value;
    }
}
