class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> store = new HashMap<>();
        Dsu dsu = new Dsu(1 + n);

        for (int[] edge : dislikes) {
            if (!store.containsKey(edge[0])) {
                store.put(edge[0], new ArrayList<>());
            }

            if (!store.containsKey(edge[1])) {
                store.put(edge[1], new ArrayList<>());
            }

            store.get(edge[0]).add(edge[1]);
            store.get(edge[1]).add(edge[0]);
        }

        for (int node = 1; n >= node; ++node) {
            if (!store.containsKey(node)) {
                continue;
            }

            for (int dislike : store.get(node)) {
                if (dsu.find(node) == dsu.find(dislike)) {
                    return false;
                }
                dsu.union(store.get(node).get(0), dislike);
            }
        }

        return true;
    }

    class Dsu {
        int[] parents;
        int[] ranks;

        public Dsu(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int idx = 0; n > idx; ++idx) {
                parents[idx] = idx;
            }
        }

        public int find(int a) {
            if (a != parents[a]) {
                parents[a] = find(parents[a]);
            }
            return parents[a];
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                if (ranks[pa] > ranks[pb]) {
                    parents[pa] = pb;
                    ++ranks[pa];
                } else {
                    parents[pb] = pa;
                    ++ranks[pb];
                }
            }
        }
    }
}
