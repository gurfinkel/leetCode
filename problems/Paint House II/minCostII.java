class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int k = costs[0].length;
        int n = costs.length;

        for (int house = 1; house < n; house++) {
            for (int color = 0; color < k; color++) {
                int min = Integer.MAX_VALUE;
                for (int previousColor = 0; previousColor < k; previousColor++) {
                    if (color == previousColor) continue;
                    min = Math.min(min, costs[house - 1][previousColor]);
                }
                costs[house][color] += min;
            }
        }

        // Find the minimum in the last row.
        int min = Integer.MAX_VALUE;
        for (int c : costs[n - 1]) {
            min = Math.min(min, c);
        }
        return min;
    }

    public boolean validTree(int n, int[][] edges) {
        return validTreeDsu(n, edges);
        // return validTreeDfs(n, edges);
    }

    private boolean validTreeDsu(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        // Condition 2: The graph must contain a single connected component.
        DisjointSetUnion dsu = new DisjointSetUnion(n);

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }

    private class DisjointSetUnion {
        private int[] parents;
        private int[] ranks;

        public DisjointSetUnion(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int idx = 0; n > idx; ++idx) {
                parents[idx] = idx;
            }
        }

        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }

            return parents[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            } else {
                if (ranks[px] > ranks[py]) {
                    parents[py] = px;
                    ++ranks[px];
                } else {
                    parents[px] = py;
                    ++ranks[py];
                }

                return true;
            }
        }
    }

    private boolean validTreeDfs(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = getGraph(edges);
        int[] colors = new int[n]; // 0 - white; 1 - gray; 2 - black
        int connectedComponentCount = 0;

        for (int idx = 0; n > idx; ++idx) {
            if (0 == colors[idx]) {
                if (!dfs(graph, colors, idx)) {
                    return false;
                } else {
                    ++connectedComponentCount;
                }
            }
        }

        return 1 == connectedComponentCount;
    }

    private HashMap<Integer, HashSet<Integer>> getGraph(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashSet<Integer>());
            }

            graph.get(edge[0]).add(edge[1]);

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new HashSet<Integer>());
            }

            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    private boolean dfs(HashMap<Integer, HashSet<Integer>> graph, int[] colors, int idx) {
        if (null == graph.get(idx)) {
            return true;
        }

        if (0 != colors[idx]) {
            return 2 == colors[idx];
        }

        colors[idx] = 1;

        for (int next : graph.get(idx)) {
            graph.get(next).remove(idx);

            if (!dfs(graph, colors, next)) {
                return false;
            }
        }

        colors[idx] = 2;

        return true;
    }
}
