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
    public int maxProduct(TreeNode root) {
        long sum = getSum(root);

        dfs(root, sum);

        return (int)(result%1_000_000_007);
    }

    long result = 0;
    HashMap<TreeNode, Long> nodeToSum = new HashMap<>();

    void dfs(TreeNode root, long totalSum) {
        if (null == root) {
            return;
        }

        long subTreeSum = nodeToSum.get(root);
        long product = subTreeSum * (totalSum - subTreeSum);

        result = Math.max(result, product);

        dfs(root.left, totalSum);
        dfs(root.right, totalSum);
    }

    long getSum(TreeNode root) {
        if (null == root) {
            return 0;
        }

        long leftSum = getSum(root.left);
        long rightSum = getSum(root.right);

        nodeToSum.put(root, leftSum + root.val + rightSum);

        return leftSum + root.val + rightSum;
    }
}
