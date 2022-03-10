class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) {
            return -1;
        }

        Dsu dsu = new Dsu(n);
        int result = -1;

        for (int[] connection : connections) {
            dsu.union(connection[0], connection[1]);
        }

        for (int idx = 0; n > idx; ++idx) {
            int parentId = dsu.find(idx);

            if (idx == parentId) {
                ++result;
            }
        }

        return result;
    }

    class Dsu {
        int[] parents;
        int[] ranks;

        public Dsu(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int idx = 0; n > idx; ++idx) {
                parents[idx] = idx;
                ranks[idx] = 1;
            }
        }

        int find(int a) {
            if (parents[a] != a) {
                parents[a] = find(parents[a]);
            }

            return parents[a];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                if (ranks[pa] > ranks[pb]) {
                    parents[pb] = pa;
                    ranks[pa] += ranks[pb];
                } else {
                    parents[pa] = pb;
                    ranks[pb] += ranks[pa];
                }
            }
        }
    }
}
