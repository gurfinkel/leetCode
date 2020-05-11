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
    public bool IsCousins(TreeNode root, int x, int y) {
        var bfs = new Queue<TreeNode>();
        bfs.Enqueue(root);

        while (0 < bfs.Count) {
            var count = bfs.Count;
            var cousins = 0;

            for (var i = 0; count > i; ++i) {
                var node = bfs.Dequeue();

                if (null != node) {
                    if (x == node.val || y == node.val) {
                        ++cousins;
                    }
                    if (null != node.left && null != node.right && (
                        (x == node.left.val && y == node.right.val) ||
                        (y == node.left.val && x == node.right.val))) {
                        return false;
                    }
                    bfs.Enqueue(node.left);
                    bfs.Enqueue(node.right);
                }

                if (1 + i == count) {
                    if (1 == cousins) {
                        return false;
                    } else if (2 == cousins) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
