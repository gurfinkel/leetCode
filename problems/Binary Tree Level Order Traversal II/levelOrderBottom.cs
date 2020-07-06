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
    public IList<IList<int>> LevelOrderBottom(TreeNode root) {
        var result = new List<IList<int>>();
        var bfs = new Queue<TreeNode>();

        if (null != root) {
            bfs.Enqueue(root);
        }

        while (0 < bfs.Count) {
            int count = bfs.Count;
            List<int> level = new List<int>();

            for (int idx = 0; count > idx; ++idx) {
                TreeNode node = bfs.Dequeue();

                level.Add(node.val);

                if (null != node.left) {
                    bfs.Enqueue(node.left);
                }
                if (null != node.right) {
                    bfs.Enqueue(node.right);
                }
            }

            result.Insert(0, level);
        }

        return result;
    }
}
