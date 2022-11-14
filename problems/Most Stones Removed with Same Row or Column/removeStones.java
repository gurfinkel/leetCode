class Solution {
    public int removeStones(int[][] stones) {
        // Adjacency list to store edges
        List<Integer>[] adj = new ArrayList[2 * K + 1];
        for (int i = 0; i < 2 * K + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1] + K;
            adj[x].add(y);
            adj[y].add(x);
        }

        // Array to mark visited stones
        int[] visited = new int[2 * K + 1];
        // Counter for connected components
        int componentCount = 0;
        for (int i = 0; i < 2 * K + 1; i++) {
            if (visited[i] == 0 && adj[i].size() > 0) {
                // If the stone is not visited yet,
                // Start the DFS and increment the counter
                componentCount++;
                dfs(stones, adj, visited, i);
            }
        }

        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }

    // Constant to map y-coordinates of stones
    final int K = 10001;
    void dfs(int[][] stones, List<Integer>[] adj, int[] visited, int src) {
        // Mark the stone as visited
        visited[src] = 1;

        // Iterate over the adjacent, and iterate over it if not visited yet
        for (int adjacent : adj[src]) {
            if (visited[adjacent] == 0) {
                dfs(stones, adj, visited, adjacent);
            }
        }
    }
}
