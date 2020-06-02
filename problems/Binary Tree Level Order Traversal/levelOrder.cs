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
    public IList<IList<int>> LevelOrder(TreeNode root) {
        var bfs = new Queue<TreeNode>();
        var result = new List<IList<int>>();

        if (null != root) bfs.Enqueue(root);

        while (0 < bfs.Count) {
            var count = bfs.Count;

            result.Add(new List<int>());

            while (0 < count--) {
                var node = bfs.Dequeue();

                if (null != node) {
                    result[result.Count - 1].Add(node.val);

                    if (null != node.left) bfs.Enqueue(node.left);
                    if (null != node.right) bfs.Enqueue(node.right);
                }
            }
        }

        return result;
    }
}
