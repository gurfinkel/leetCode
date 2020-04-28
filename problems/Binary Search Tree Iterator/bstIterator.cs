/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {

    public BSTIterator(TreeNode root) {
        leftMostInorder(root);
    }

    /** @return the next smallest number */
    public int Next() {
        var nextNode = stack.Pop();

        if (null != nextNode.right) {
            leftMostInorder(nextNode.right);
        }

        return nextNode.val;
    }

    /** @return whether we have a next smallest number */
    public bool HasNext() {
        return 0 < stack.Count;
    }

    private readonly Stack<TreeNode> stack = new Stack<TreeNode>();
    private void leftMostInorder(TreeNode node) {
        while (null != node) {
            stack.Push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */
