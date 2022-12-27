class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        Queue<Integer> bfs = new LinkedList<>();

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashSet<>());
            }
            graph.get(edge[0]).add(edge[1]);

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new HashSet<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }

        bfs.add(source);

        while (!bfs.isEmpty()) {
            int vertex = bfs.poll();

            if (destination == vertex) {
                return true;
            }

            for (int idx = 0; n > idx; ++idx) {
                if (graph.containsKey(vertex) && graph.get(vertex).contains(idx)) {
                    bfs.add(idx);
                    graph.get(vertex).remove(idx);
                    graph.get(idx).remove(vertex);
                }
            }
        }

        return false;
    }
}
