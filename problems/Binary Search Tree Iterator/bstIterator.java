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
class BSTIterator {

    public BSTIterator(TreeNode root) {
        idx = 0;
        inorder = new ArrayList<>();

        fillInOrder(root, inorder);
    }

    public int next() {
        return inorder.get(idx++);
    }

    public boolean hasNext() {
        return idx < inorder.size();
    }

    private int idx;
    private List<Integer> inorder;

    private void fillInOrder(TreeNode node, List<Integer> inorder) {
        if (null == node) {
            return;
        }

        fillInOrder(node.left, inorder);
        inorder.add(node.val);
        fillInOrder(node.right, inorder);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
