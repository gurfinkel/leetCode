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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inOrder = getInOrder(root);
        HashSet<Integer> store = new HashSet<Integer>();

        for (int item : inOrder) {
            if (store.contains(k - item)) {
                return true;
            }

            store.add(item);
        }

        return false;
    }

    private List<Integer> getInOrder(TreeNode node) {
        List<Integer> inOrder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = node;

        while (null != curr || !stack.isEmpty()) {
            while (null != curr) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            inOrder.add(curr.val);
            curr = curr.right;
        }

        return inOrder;
    }
}
