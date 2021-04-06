class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        int n = isConnected.length;
        Dsu dsu = new Dsu(n);

        for (int i = 0; n > i; ++i) {
            for (int j = 0; i > j; ++j) {
                if (1 == isConnected[i][j]) {
                    dsu.union(i, j);
                }
            }
        }

        for (int idx = 0; n > idx; ++idx) {
            if (dsu.find(idx) == idx) {
                ++result;
            }
        }

        return result;
    }

    class Dsu {
        int[] _parents;
        int[] _ranks;

        public Dsu(int n) {
            _parents = new int[n];
            _ranks = new int[n];

            for (int idx = 0; n > idx; ++ idx) {
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
