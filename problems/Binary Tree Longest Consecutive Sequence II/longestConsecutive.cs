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
    public int LongestConsecutive(TreeNode root) {
        int res = 0;
        DFS(ref res, root, out _, out _);
        return res;
    }

    private void DFS(ref int res,TreeNode node, out int decrPath, out int incrPath)
    {
        if (node == null)
        {
            decrPath = 0;
            incrPath = 0;
            return;
        }

        DFS(ref res, node.left, out int innerLeftDecrPath, out int innerLeftIncrPath);
        DFS(ref res, node.right, out int innerRightDecrPath, out int innerRightIncrPath);

        int cand1 = 1;
        int cand2 = 1;

        if (innerLeftDecrPath > 0 && node.left.val == node.val - 1)
        {
            cand1 += innerLeftDecrPath;
            if (innerRightIncrPath > 0 && node.right.val == node.val + 1)
            {
                cand1 += innerRightIncrPath;
            }
        }

        if (innerRightDecrPath > 0 && node.right.val == node.val - 1)
        {
            cand2 += innerRightDecrPath;
            if (innerLeftIncrPath > 0 && node.left.val == node.val + 1)
            {
                cand2 += innerLeftIncrPath;
            }
        }

        res = Math.Max(res, cand1);
        res = Math.Max(res, cand2);


        decrPath = 1;
        incrPath = 1;

        if (innerLeftDecrPath > 0 && node.left.val == node.val - 1)
        {
            decrPath = Math.Max(decrPath, innerLeftDecrPath + 1);
        }

        if (innerRightDecrPath > 0 && node.right.val == node.val - 1)
        {
            decrPath = Math.Max(decrPath, innerRightDecrPath + 1);
        }

        if (innerRightIncrPath > 0 && node.right.val == node.val + 1)
        {
            incrPath = Math.Max(incrPath, innerRightIncrPath + 1);
        }

        if (innerLeftIncrPath > 0 && node.left.val == node.val + 1)
        {
            incrPath = Math.Max(incrPath, innerLeftIncrPath + 1);
        }

        res = Math.Max(res, incrPath);
        res = Math.Max(res, decrPath);
    }
}
