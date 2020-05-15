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
    public IList<int> RightSideView(TreeNode root) {
        var result = new List<int>();
        var bfs = new Queue<TreeNode>();

        if (null != root) {
            bfs.Enqueue(root);
        }

        while (0 < bfs.Count) {
            var count = bfs.Count;
            TreeNode node = null;

            for (var i = 0; count > i; ++i) {
                node = bfs.Dequeue();

                if (null != node.left) {
                    bfs.Enqueue(node.left);
                }
                if (null != node.right) {
                    bfs.Enqueue(node.right);
                }
            }

            result.Add(node.val);
        }

        return result;
    }
}
