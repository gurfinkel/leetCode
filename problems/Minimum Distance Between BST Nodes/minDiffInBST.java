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
    public int minDiffInBST(TreeNode root) {
        int result = Integer.MAX_VALUE;
        List<Integer> inOrderStore = new ArrayList<>();

        fillInOrder(root, inOrderStore);

        for (int idx = 1; inOrderStore.size() > idx; ++idx) {
            result = Math.min(result, Math.abs(inOrderStore.get(idx - 1) - inOrderStore.get(idx)));
        }

        return result;
    }

    private void fillInOrder(TreeNode node, List<Integer> inOrderStore) {
        if (null == node) {
            return;
        }

        fillInOrder(node.left, inOrderStore);
        inOrderStore.add(node.val);
        fillInOrder(node.right, inOrderStore);
    }
}
