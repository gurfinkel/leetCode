class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> store = new HashMap<>();
        int[] color = new int[1 + n];

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            if (!store.containsKey(a)) {
                store.put(a, new ArrayList<>());
            }

            if (!store.containsKey(b)) {
                store.put(b, new ArrayList<>());
            }

            store.get(a).add(b);
            store.get(b).add(a);
        }

        for (int idx = 1; n >= idx; ++idx) {
            if (0 == color[idx]) {
                if (!bfs(idx, store, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int idx, HashMap<Integer, List<Integer>> store, int[] color) {
        Queue<Integer> bfs = new LinkedList<>();

        bfs.add(idx);
        color[idx] = 1;

        while (!bfs.isEmpty()) {
            int node = bfs.poll();

            if (!store.containsKey(node)) {
                continue;
            }

            for (int neighbor : store.get(node)) {
                if (1 == color[neighbor]) {
                    return false;
                } else if (0 == color[neighbor]) {
                    color[neighbor] = 1;
                    bfs.add(neighbor);
                }
            }
        }
        return true;
    }
}
