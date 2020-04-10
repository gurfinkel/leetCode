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
    public bool IsCompleteTree(TreeNode root) {
        var bfs = (new [] { new { Node=root, Code=1 }}).ToList();
        var count = 0;
        var lastCode = 0;

        while (0 < bfs.Count) {
            var curr = bfs[0];
            bfs.RemoveAt(0);

            if (null != curr.Node) {
                ++count;
                lastCode = curr.Code;

                bfs.Add(new {Node=curr.Node.left, Code=(curr.Code<<1)});
                bfs.Add(new {Node=curr.Node.right, Code=(1+(curr.Code<<1))});
            }
        }

        return count == lastCode;
    }
}
