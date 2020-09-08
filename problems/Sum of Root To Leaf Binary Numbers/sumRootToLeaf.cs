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
    public int SumRootToLeaf(TreeNode root) {
        int result = 0;

        dfs(root, ref result);

        return result;
    }

    private void dfs(TreeNode node, ref int result, String currNum = "") {
        if (null == node) {
            return;
        }

        currNum += node.val.ToString();

        if (null == node.left && null == node.right) {
            result += Convert.ToInt32(currNum, 2);
        } else {
            dfs(node.left, ref result, currNum);
            dfs(node.right, ref result, currNum);
        }
    }
}
