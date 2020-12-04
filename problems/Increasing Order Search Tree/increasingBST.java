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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        TreeNode fakeRoot = new TreeNode();
        TreeNode currNode = fakeRoot;

        fillInOrder(root, inOrder);

        for (int val : inOrder) {
            currNode.right = new TreeNode(val);
            currNode = currNode.right;
        }

        return fakeRoot.right;
    }

    private void fillInOrder(TreeNode node, List<Integer> inOrder) {
        if (null == node) {
            return;
        }

        fillInOrder(node.left, inOrder);
        inOrder.add(node.val);
        fillInOrder(node.right, inOrder);
    }
}
