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
    public IList<IList<int>> PathSum(TreeNode root, int sum) {
        var result = new List<IList<int>>();

        dfs(root, sum, result);

        return result;
    }

    private void dfs(TreeNode node, int sum, List<IList<int>> res, string path = "") {
        if (null == node) {
            return;
        }

        path += "" == path ? node.val.ToString() : "," + node.val;
        sum -= node.val;

        if (null == node.left && null == node.right && 0 == sum) {
            res.Add(path.Split(',').Select(item => int.Parse(item)).ToList());
            return;
        }

        dfs(node.left, sum, res, path);
        dfs(node.right, sum, res, path);
    }
}
