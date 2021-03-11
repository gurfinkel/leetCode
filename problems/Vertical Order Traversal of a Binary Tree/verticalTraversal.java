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
        List<List<Integer>> result = new ArrayList();
        Queue<Triplet<TreeNode, Integer, Integer>> bfs = new LinkedList<>();
        List<Triplet<Integer, Integer, Integer>> nodes = new ArrayList();

        if (null != root) {
            bfs.add(new Triplet(root, 0, 0));
        } else {
            return result;
        }

        while (!bfs.isEmpty()) {
            int count = bfs.size();

            for (int idx = 0; count > idx; ++idx) {
                Triplet<TreeNode, Integer, Integer> node = bfs.poll();
                nodes.add(new Triplet(node.val.val, node.row, node.col));

                if (null != node.val.left) {
                    bfs.add(new Triplet(node.val.left, 1 + node.row, node.col - 1));
                }

                if (null != node.val.right) {
                    bfs.add(new Triplet(node.val.right, 1 + node.row, node.col + 1));
                }
            }
        }

        Collections.sort(nodes, new Comparator<Triplet<Integer, Integer, Integer>>() {
            @Override
            public int compare(Triplet<Integer, Integer, Integer> t1,
                    Triplet<Integer, Integer, Integer> t2) {
                if (t1.col.equals(t2.col)) {
                    if (t1.row.equals(t2.row)) {
                        return t1.val - t2.val;
                    } else {
                        return t1.row - t2.row;
                    }
                } else {
                    return t1.col - t2.col;
                }
            }
        });

        Integer currColumnIndex = nodes.get(0).col;
        List<Integer> currColumn = new ArrayList();

        for (Triplet<Integer, Integer, Integer> node : nodes) {
            if (node.col == currColumnIndex) {
                currColumn.add(node.val);
            } else {
                result.add(currColumn);
                currColumnIndex = node.col;
                currColumn = new ArrayList();
                currColumn.add(node.val);
            }
        }

        result.add(currColumn);

        return result;
    }

    class Triplet<A, B, C> {
        public final A val;
        public final B row;
        public final C col;


        public Triplet(A val, B row, C col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
