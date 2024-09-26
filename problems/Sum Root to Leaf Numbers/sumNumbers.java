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
    public int sumNumbers(TreeNode root) {
        int result = 0;
        Stack<Pair<TreeNode, Integer>> bfs = new Stack<>();

        if (null != root) {
            bfs.add(new Pair(root, 0));
        }

        while (!bfs.isEmpty()) {
            Pair<TreeNode, Integer> pair = bfs.pop();
            TreeNode node = pair.getKey();
            int currNumber = pair.getValue();

            currNumber = 10 * currNumber + node.val;

            if (null == node.left && null == node.right) {
                result += currNumber;
            } else {
                if (null != node.left) {
                    bfs.push(new Pair(node.left, currNumber));
                }
                if (null != node.right) {
                    bfs.push(new Pair(node.right, currNumber));
                }
            }
        }
        return result;
    }
}
