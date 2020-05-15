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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();

        if (null != root) {
            bfs.add(root);
        }

        while (0 < bfs.size()) {
            int count = bfs.size();
            TreeNode node = null;

            while (0 < count--) {
                node = bfs.poll();

                if (null != node.left) {
                    bfs.add(node.left);
                }

                if (null != node.right) {
                    bfs.add(node.right);
                }
            }

            result.add(node.val);
        }

        return result;
    }
}
