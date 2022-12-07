class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(graph, 0, new ArrayList<>(), result);

        return result;
    }

    void dfs (int[][] graph, int currIdx, List<Integer> path, List<List<Integer>> result) {
        path.add(currIdx);

        if (graph.length - 1 == currIdx) {
            result.add(path);
        } else {
            for (int nextIdx : graph[currIdx]) {
                dfs(graph, nextIdx, new ArrayList<>(path), result);
            }
        }
    }
}
