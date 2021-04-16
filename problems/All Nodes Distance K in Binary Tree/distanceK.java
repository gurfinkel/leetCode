/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> bfs = new LinkedList();
        Set<TreeNode> visited = new HashSet();
        int dist = 0;

        dfs(root, parents);
        bfs.add(target);
        visited.add(target);

        while (!bfs.isEmpty()) {
            int count = bfs.size();

            for (int idx = 0; count > idx; ++idx) {
                TreeNode node = bfs.poll();

                if (K == dist) {
                    result.add(node.val);
                } else {
                    TreeNode parent = parents.get(node);

                    if (null != node.left && !visited.contains(node.left)) {
                        bfs.offer(node.left);
                        visited.add(node.left);
                    }
                    if (null != node.right && !visited.contains(node.right)) {
                        bfs.offer(node.right);
                        visited.add(node.right);
                    }
                    if (null != parent && !visited.contains(parent)) {
                        bfs.offer(parent);
                        visited.add(parent);
                    }
                }
            }

            ++dist;
        }

        return result;
    }

    void dfs(TreeNode node, HashMap<TreeNode, TreeNode> parents) {
        if (null == node) {
            return;
        }

        if (null != node.left) {
            parents.put(node.left, node);
            dfs(node.left, parents);
        }

        if (null != node.right) {
            parents.put(node.right, node);
            dfs(node.right, parents);
        }
    }
}
