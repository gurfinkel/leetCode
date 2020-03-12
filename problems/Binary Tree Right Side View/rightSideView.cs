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
    public IList<int> RightSideView(TreeNode root) {
        if (root == null)
        {
            return new List<int>();
        }

        Queue<TreeNode> bfs = new Queue<TreeNode>();
        bfs.Enqueue(root);
        IList<int> res = new List<int>();

        while (bfs.Count != 0)
        {
            int count = bfs.Count;
            TreeNode node = null;
            for (int i = 0; i < count; i++)
            {
                node = bfs.Dequeue();

                if (node.left != null)
                {
                    bfs.Enqueue(node.left);
                }

                if (node.right != null)
                {
                    bfs.Enqueue(node.right);
                }
            }

            res.Add(node.val);
        }

        return res;
    }
}
