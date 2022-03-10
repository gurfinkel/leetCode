class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] discoveredTime = new int[n];
        int[] low = new int[n];

        Arrays.fill(discoveredTime, -1);

        for (List<Integer> connection : connections) {
            if (graph.containsKey(connection.get(0))) {
                graph.get(connection.get(0)).add(connection.get(1));
            } else {
                List<Integer> items = new ArrayList<>();

                items.add(connection.get(1));
                graph.put(connection.get(0), items);
            }

            if (graph.containsKey(connection.get(1))) {
                graph.get(connection.get(1)).add(connection.get(0));
            } else {
                List<Integer> items = new ArrayList<>();

                items.add(connection.get(0));
                graph.put(connection.get(1), items);
            }
        }

        dfs(0, 0, discoveredTime, low, graph, bridges);

        return bridges;
    }

    private int time = 0;

    private void dfs(int u, int parent, int[] discoveredTime, int[] low, HashMap<Integer, List<Integer>> graph, List<List<Integer>> bridges) {
        discoveredTime[u] = time;
        low[u] = time++;

        for (int v : graph.get(u)) {
            if (parent == v) {
                continue;
            }

            if (-1 == discoveredTime[v]) {
                dfs(v, u, discoveredTime, low, graph, bridges);

                low[u] = Math.min(low[u], low[v]);

                if (discoveredTime[u] < low[v]) {
                    List<Integer> items = new ArrayList<>();

                    items.add(u);
                    items.add(v);
                    bridges.add(items);
                }
            } else {
                low[u] = Math.min(low[u], discoveredTime[v]);
            }
        }
    }
}
