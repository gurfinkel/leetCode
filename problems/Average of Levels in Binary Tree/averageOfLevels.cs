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
    public IList<double> AverageOfLevels(TreeNode root) {
        var result = new List<double>();

        if (null == root) {
            return result;
        }

        var bfs = new Queue<TreeNode>();

        bfs.Enqueue(root);

        while (0 < bfs.Count) {
            var count = bfs.Count;
            double sum = 0;

            for (var i = 0; count > i; ++i) {
                var curr = bfs.Dequeue();

                sum += curr.val;
                if (null != curr.left) {
                    bfs.Enqueue(curr.left);
                }
                if (null != curr.right) {
                    bfs.Enqueue(curr.right);
                }
            }

            result.Add(sum / count);
        }

        return result;
    }
}
