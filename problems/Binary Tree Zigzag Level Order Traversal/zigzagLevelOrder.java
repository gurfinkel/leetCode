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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
          return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
          TreeNode curr_node = node_queue.pollFirst();
          if (curr_node != null) {
            if (is_order_left)
              level_list.addLast(curr_node.val);
            else
              level_list.addFirst(curr_node.val);

            if (curr_node.left != null)
              node_queue.addLast(curr_node.left);
            if (curr_node.right != null)
              node_queue.addLast(curr_node.right);

          } else {
            // we finish the scan of one level
            results.add(level_list);
            level_list = new LinkedList<Integer>();
            // prepare for the next level
            if (node_queue.size() > 0)
              node_queue.addLast(null);
            is_order_left = !is_order_left;
          }
        }
        return results;
    }
}
