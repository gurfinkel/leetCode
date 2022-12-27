class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> store = new HashSet<>();
        Dsu dsu = new Dsu(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int idx = 0; n > idx; ++idx) {
            store.add(dsu.find(idx));
        }

        return store.size();
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
