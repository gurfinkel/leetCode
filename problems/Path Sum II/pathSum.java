/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, targetSum, new ArrayList<>(), result);

        return result;
    }

    private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result) {
        if (null == node) {
            return;
        }

        sum -= node.val;
        path.add(node.val);

        if (null == node.left && null == node.right && 0 == sum) {
            result.add(path);
        } else {
            dfs(node.left, sum, new ArrayList(path), result);
            dfs(node.right, sum, new ArrayList(path), result);
        }
    }
}
