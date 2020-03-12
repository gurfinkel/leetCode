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
    public IList<int> LargestValues(TreeNode root) {
        ISet<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> bfs = new Queue<TreeNode>();

        if (root == null)
        {
            return new List<int>();
        }

        bfs.Enqueue(root);
        visited.Add(root);
        IList<int> res = new List<int>();

        while (bfs.Count != 0)
        {
            int count = bfs.Count;
            int max = int.MinValue;
            for (int i = 0; i < count; i++)
            {
                var curr = bfs.Dequeue();
                max = Math.Max(max, curr.val);
                if (curr.left != null && visited.Add(curr.left))
                {
                    bfs.Enqueue(curr.left);
                }
                if (curr.right != null && visited.Add(curr.right))
                {
                    bfs.Enqueue(curr.right);
                }
            }

            res.Add(max);
        }

        return res;
    }
}
