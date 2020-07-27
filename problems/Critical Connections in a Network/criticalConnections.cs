public class Solution {
    public IList<IList<int>> CriticalConnections(int n, IList<IList<int>> connections) {
        IList<IList<int>> bridges = new List<IList<int>>();
        Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        int[] discoveredTime = new int[n];
        int[] low = new int[n];

        Array.Fill(discoveredTime, -1);

        foreach (List<int> connection in connections) {
            if (graph.ContainsKey(connection[0])) {
                graph[connection[0]].Add(connection[1]);
            } else {
                graph.Add(connection[0], new List<int> {connection[1]});
            }

            if (graph.ContainsKey(connection[1])) {
                graph[connection[1]].Add(connection[0]);
            } else {
                graph.Add(connection[1], new List<int> {connection[0]});
            }
        }

        dfs(0, 0, discoveredTime, low, graph, bridges);

        return bridges;
    }

    private int time = 0;

    private void dfs(int u, int parent, int[] discoveredTime, int[] low, Dictionary<int, List<int>> graph, IList<IList<int>> bridges) {
        discoveredTime[u] = time;
        low[u] = time++;

        foreach (int v in graph[u]) {
            if (parent == v) {
                continue;
            }

            if (-1 == discoveredTime[v]) {
                dfs(v, u, discoveredTime, low, graph, bridges);

                low[u] = Math.Min(low[u], low[v]);

                if (discoveredTime[u] < low[v]) {
                    bridges.Add(new List<int> {u, v});
                }
            } else {
                low[u] = Math.Min(low[u], discoveredTime[v]);
            }
        }
    }
}
