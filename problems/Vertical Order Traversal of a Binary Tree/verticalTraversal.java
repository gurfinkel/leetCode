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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<NodeAndCol> bfs = new LinkedList<>();
        HashMap<Integer, List<Integer>> store = new HashMap<>();
        PriorityQueue<NodeAndCol> rowHeap = new PriorityQueue<>((a,b)->a.col == b.col ? a.node.val - b.node.val : a.col - b.col);
        int maxCol = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;

        if (null != root) {
            bfs.add(new NodeAndCol(root, 0));
        }

        while (!bfs.isEmpty()) {
            for (int idx = bfs.size(); 0 < idx; --idx) {
                NodeAndCol nodeAndCol = bfs.poll();
                TreeNode node = nodeAndCol.node;
                int col = nodeAndCol.col;

                if (null != node.left) {
                    bfs.add(new NodeAndCol(node.left, col - 1));
                }

                if (null != node.right) {
                    bfs.add(new NodeAndCol(node.right, 1 + col));
                }

                rowHeap.add(nodeAndCol);
                maxCol = Math.max(maxCol, col);
                minCol = Math.min(minCol, col);
            }

            while (!rowHeap.isEmpty()) {
                NodeAndCol nodeAndCol = rowHeap.poll();
                TreeNode node = nodeAndCol.node;
                int col = nodeAndCol.col;

                if (!store.containsKey(col)) {
                    store.put(col, new ArrayList<>());
                }

                store.get(col).add(node.val);
            }
        }

        for (int col = minCol; maxCol >= col; ++col) {
            if (store.containsKey(col)) {
                result.add(store.get(col));
            }
        }

        return result;
    }

    class NodeAndCol {
        TreeNode node;
        int col;

        public NodeAndCol(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }
}
