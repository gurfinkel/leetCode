public class Solution {
    public int NumIslands(char[][] grid) {
        if (null == grid || 0 == grid.Length) {
            return 0;
        }

        var nr = grid.Length;
        var nc = grid[0].Length;
        var dsu = new Dsu(grid);

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if ('1' == grid[r][c]) {
                    grid[r][c] = '0';

                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        dsu.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        dsu.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        dsu.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        dsu.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return dsu.getCount();
    }

    private class Dsu {
        private int _connectedComponentsCount = 0;
        private readonly int[] _parents;
        private readonly int[] _ranks;

        public Dsu(char[][] grid) {
            var rows = grid.Length;
            var cols = grid[0].Length;

            _parents = new int[rows * cols];
            _ranks = new int[rows * cols];

            for (var row = 0; rows > row; ++row) {
                for (var col = 0; cols > col; ++col) {
                    if ('1' == grid[row][col]) {
                        _parents[row * cols + col] = row * cols + col;
                        ++_connectedComponentsCount;
                    }
                }
            }
        }

        public int getCount() {
            return _connectedComponentsCount;
        }

        public int find(int x) {
            if (_parents[x] != x) {
                x = find(_parents[x]);
            }

            return _parents[x];
        }

        public bool union(int x, int y) {
            var px = find(x);
            var py = find(y);

            if (px == py) {
                return false;
            }

            if (_ranks[px] > _ranks[py]) {
                _parents[py] = px;
                ++_ranks[px];
            } else {
                _parents[px] = py;
                ++_ranks[py];
            }

            --_connectedComponentsCount;

            return true;
        }
    }
}
