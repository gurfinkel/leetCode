class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        Dsu dsu = new Dsu(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int idx = 0; n > idx; ++idx) {
            if (idx == dsu.find(idx)) {
                ++result;
            }
        }

        return result;
    }

    class Dsu {
        private final int[] _parents;
        private final int[] _ranks;

        public Dsu(int n) {
            _parents = new int[n];
            _ranks = new int[n];

            for (int idx = 0; n > idx; ++idx) {
                _parents[idx] = idx;
            }
        }

        public int find(int x) {
            if (x != _parents[x]) {
                _parents[x] = find(_parents[x]);
            }

            return _parents[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px != py) {
                if (_ranks[px] > _ranks[py]) {
                    _parents[py] = px;
                    ++_ranks[px];
                } else {
                    _parents[px] = py;
                    ++_ranks[py];
                }
            }
        }
    }
}
