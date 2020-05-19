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
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> inorder = new ArrayList<Integer>();
        int result = 0;

        fillInorder(root, inorder);

        for (int item : inorder) {
            if (L <= item && R >= item) {
                result += item;
            }
        }

        return result;
    }

    private void fillInorder(TreeNode node, List<Integer> inorder) {
        if (null == node) {
            return;
        }

        fillInorder(node.left, inorder);
        inorder.add(node.val);
        fillInorder(node.right, inorder);
    }
}
