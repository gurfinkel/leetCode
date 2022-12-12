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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> leafs1 = getLeafs(root1);
        List<TreeNode> leafs2 = getLeafs(root2);

        if (leafs1.size() != leafs2.size()) {
            return false;
        }

        for (int idx = 0; leafs1.size() > idx; ++idx) {
            if (leafs1.get(idx).val != leafs2.get(idx).val) {
                return false;
            }
        }

        return true;
    }

    List<TreeNode> getLeafs(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        dfs(root, result);

        return result;
    }

    void dfs(TreeNode root, List<TreeNode> result) {
        if (null == root) {
            return;
        }

        if (null == root.left && null == root.right) {
            result.add(root);
        } else {
            dfs(root.left, result);
            dfs(root.right, result);
        }
    }
}
