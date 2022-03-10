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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        HashMap<String, Integer> keyToId = new HashMap<>();
        HashMap<Integer, Integer> idToCount = new HashMap<>();

        dfs(root, keyToId, idToCount, result);

        return result;
    }

    private int dfs(TreeNode node, HashMap<String, Integer> keyToId, HashMap<Integer, Integer> idToCount, List<TreeNode> result) {
        if (null == node) {
            return 0;
        }

        int left = dfs(node.left, keyToId, idToCount, result);
        int right = dfs(node.right, keyToId, idToCount, result);
        String key = left+","+right+","+node.val;
        int id = 1 + keyToId.size();

        if (keyToId.containsKey(key)) {
            id = keyToId.get(key);
        } else {
            keyToId.put(key, id);
        }

        idToCount.put(id, 1 + idToCount.getOrDefault(id, 0));

        if (2 == idToCount.get(id)) {
            result.add(node);
        }

        return id;
    }
}
