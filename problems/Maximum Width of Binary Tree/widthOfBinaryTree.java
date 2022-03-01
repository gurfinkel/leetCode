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
    public int widthOfBinaryTree(TreeNode root) {
        return 1 + getMaxWidth(root, 1, new ArrayList<Integer>(), new ArrayList<Integer>(), 1);
    }

    int getMaxWidth(TreeNode root, int level, ArrayList<Integer> start, ArrayList<Integer> end, int pos) {
        if (null == root) {
            return 0;
        }

        if (start.size() < level) {
            start.add(pos);
            end.add(pos);
        } else {
            end.set(level - 1, pos);
        }

        int left = getMaxWidth(root.left, 1 + level, start, end, pos*2-1);
        int right = getMaxWidth(root.right, 1 + level, start, end, pos*2);
        int cur = end.get(level - 1) - start.get(level - 1);

        return Math.max(cur, Math.max(left, right));

    }
}
