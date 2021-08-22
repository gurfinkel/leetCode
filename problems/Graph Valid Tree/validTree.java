class Solution {
    public boolean validTree(int n, int[][] edges) {
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
