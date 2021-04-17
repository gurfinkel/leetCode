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
    public int largestBSTSubtree(TreeNode root) {
        if (null == root) {
            return 0;
        }

		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return countNodes(root);
		}

		return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
	}


	private boolean isBST(TreeNode node, int lo, int hi) {
		if (null == node) {
            return true;
        }

		if (lo >= node.val || hi <= node.val) {
            return false;
        }

		return isBST(node.left, lo, node.val) && isBST(node.right, node.val, hi);
	}

	private int countNodes(TreeNode node) {
		if (node == null) {
            return 0;
        }

		return 1 + countNodes(node.left) + countNodes(node.right);
	}
}
