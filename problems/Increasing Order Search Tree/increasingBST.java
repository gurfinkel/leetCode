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
    public TreeNode increasingBST(TreeNode root) {
        // return increasingBstDfs(root);
        return increasingBstBfs(root);
    }

    TreeNode increasingBstBfs(TreeNode root) {
        Stack<TreeNode> bfs = new Stack<>();
        TreeNode fakeHead = new TreeNode();
        TreeNode node = fakeHead;
        TreeNode curr = root;

        while (null != curr || !bfs.isEmpty()) {
            while (null != curr) {
                bfs.push(curr);
                curr = curr.left;
            }
            curr = bfs.pop();
            node.right = new TreeNode(curr.val);
            node = node.right;
            curr = curr.right;
        }

        return fakeHead.right;
    }

    TreeNode increasingBstDfs(TreeNode root) {
        List<TreeNode> store = new ArrayList<>();
        TreeNode fakeHead = new TreeNode();
        TreeNode node = fakeHead;

        inOrderDfs(root, store);

        for (TreeNode item : store) {
            node.right = new TreeNode(item.val);
            node = node.right;
        }

        return fakeHead.right;
    }

    void inOrderDfs(TreeNode node, List<TreeNode> store) {
        if (null == node) {
            return;
        }

        inOrderDfs(node.left, store);
        store.add(node);
        inOrderDfs(node.right, store);
    }
}
