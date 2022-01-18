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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<NodeAndCol> bfs = new LinkedList<>();
        HashMap<Integer, List<Integer>> store = new HashMap<>();
        int maxCol = 0;
        int minCol = 0;

        if (null == root) {
            return result;
        } else {
            bfs.add(new NodeAndCol(root, 0));
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int idx = 0; size > idx; ++idx) {
                NodeAndCol nodeAndCol = bfs.poll();
                TreeNode node = nodeAndCol.node;

                if (!store.containsKey(nodeAndCol.col)) {
                    store.put(nodeAndCol.col, new ArrayList<>());
                }

                if (null != node.left) {
                    bfs.add(new NodeAndCol(node.left, nodeAndCol.col - 1));
                }

                if (null != node.right) {
                    bfs.add(new NodeAndCol(node.right, nodeAndCol.col + 1));
                }

                maxCol = Math.max(maxCol, nodeAndCol.col);
                minCol = Math.min(minCol, nodeAndCol.col);
                store.get(nodeAndCol.col).add(node.val);
            }
        }

        for (int col = minCol; maxCol >= col; ++col) {
            if (store.containsKey(col)) {
                result.add(store.get(col));
            }
        }

        return result;
    }

    private class NodeAndCol {
        public TreeNode node;
        public int col;

        public NodeAndCol(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }
}
