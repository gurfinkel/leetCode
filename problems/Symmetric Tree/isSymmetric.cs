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
    public bool IsSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        var queue = new Queue<TreeNode>();
        queue.Enqueue(root.left);
        queue.Enqueue(root.right);

        while (0 < queue.Count) {
            var node1 = queue.Dequeue();
            var node2 = queue.Dequeue();

            if (null == node1 && null == node2) continue;
            if (null == node1 || null == node2) return false;
            if (node1.val != node2.val) return false;

            queue.Enqueue(node1.left);
            queue.Enqueue(node2.right);
            queue.Enqueue(node1.right);
            queue.Enqueue(node2.left);
        }

        return true;
    }
}
