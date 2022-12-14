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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, result);

        return result;
    }

    int dfs(TreeNode node, List<List<Integer>> result) {
        if (null == node) {
            return 0;
        }

        int left = dfs(node.left, result);
        int right = dfs(node.right, result);
        int currLevel = Math.max(left, right);

        if (currLevel == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(currLevel).add(node.val);

        return 1 + currLevel;
    }
}
