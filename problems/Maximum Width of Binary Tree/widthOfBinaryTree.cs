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
    public int WidthOfBinaryTree(TreeNode root) {
        var bfs = (new [] {new { Node = root, Depth = 0, Position = 0 }}).ToList();
        var depth = 0;
        var left = 0;
        var result = 0;

        while (0 < bfs.Count) {
            var curr = bfs[0];
            bfs.RemoveAt(0);

            if (null != curr.Node) {
                bfs.Add(new { Node = curr.Node.left, Depth = 1 + curr.Depth, Position = curr.Position << 1 });
                bfs.Add(new { Node = curr.Node.right, Depth = 1 + curr.Depth, Position = 1 + (curr.Position << 1) });

                if (depth != curr.Depth) {
                    depth = curr.Depth;
                    left = curr.Position;
                }

                result = Math.Max(result, 1 + curr.Position - left);
            }
        }

        return result;
    }
}
