public class Solution {
    public IList<IList<int>> AllPathsSourceTarget(int[][] graph) {
        var result = new List<IList<int>>();

        dfs(graph, new List<int>(), result);

        return result;
    }

    private void dfs(int[][] graph, List<int> path, IList<IList<int>> result, int idx = 0) {
        path.Add(idx);

        if (graph.Length - 1 == idx) {
            result.Add(path);
        } else {
            foreach (var item in graph[idx]) {
                dfs(graph, new List<int> (path), result, item);
            }
        }
    }
}
