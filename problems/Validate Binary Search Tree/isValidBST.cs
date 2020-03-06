/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public bool IsValidBST(TreeNode root) {
        // var inorderStore = new List<int>();
        // fillInorderStore(root, inorderStore);

        var inorderStore = getInorderStore(root);

        for (var i = 1; inorderStore.Count > i; ++i) {
            if (inorderStore[i] <= inorderStore[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private void fillInorderStore(TreeNode root, List<int> store) {
        if (null == root) {
            return;
        }

        fillInorderStore(root.left, store);
        store.Add(root.val);
        fillInorderStore(root.right, store);
    }

    private List<int> getInorderStore(TreeNode root) {
        var store = new Stack<TreeNode>();
        var curr = root;
        var result = new List<int>();

        while (null != curr || 0 < store.Count) {
            while (null != curr) {
                store.Push(curr);
                curr = curr.left;
            }

            curr = store.Pop();
            result.Add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}
