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
    public int closestValue(TreeNode root, double target) {
        int result = 0;
        double minDiff = Integer.MAX_VALUE;
        List<Integer> inOrder = new ArrayList();

        fillInOrder(root, inOrder);

        for (int idx = 0; inOrder.size() > idx; ++idx) {
            int value = inOrder.get(idx);

            if (Math.abs(target - value) < minDiff) {
                minDiff = Math.abs(target - value);
                result = value;
            }
        }

        return result;
    }

    public void fillInOrder(TreeNode node, List<Integer> inOrder) {
        if (null == node) {
            return;
        }

        fillInOrder(node.left, inOrder);
        inOrder.add(node.val);
        fillInOrder(node.right, inOrder);
    }
}
