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
    public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        List<StringBuilder> store = new ArrayList<>();

        dfs(root, new StringBuilder(), store);

        for (StringBuilder path : store) {
            result += Integer.parseInt(path.toString(), 2);
        }

        return result;
    }

    private void dfs(TreeNode node, StringBuilder path, List<StringBuilder> store) {
        if (null == node) {
            return;
        }

        path.append(node.val);

        if (null == node.left && null == node.right) {
            store.add(path);
        } else if (null == node.left) {
            dfs(node.right, path, store);
        } else if (null == node.right) {
            dfs(node.left, path, store);
        } else {
            dfs(node.left, new StringBuilder(path), store);
            dfs(node.right, new StringBuilder(path), store);
        }
    }
}
