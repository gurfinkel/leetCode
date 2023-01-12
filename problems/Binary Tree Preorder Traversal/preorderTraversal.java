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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        fillPreOrder(root, result);

        return result;
    }

    void fillPreOrder(TreeNode node, List<Integer> preOrder) {
        if (null == node) {
            return;
        }

        preOrder.add(node.val);
        fillPreOrder(node.left, preOrder);
        fillPreOrder(node.right, preOrder);
    }
}
