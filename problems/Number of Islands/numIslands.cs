public class Solution {
    public int NumIslands(char[][] grid) {
        if (null == grid || 0 == grid.Length) {
            return 0;
        }

        var rows = grid.Length;
        var cols = grid[0].Length;
        var dsu = new Dsu(grid);

        for (var row = 0; rows > row; ++row) {
            for (var col = 0; cols > col; ++col) {
                if ('1' == grid[row][col]) {
                    grid[row][col] = '0';

                    if (0 < row && '1' == grid[row - 1][col]) {
                        dsu.union(cols * row + col, cols * (row - 1) + col);
                    }
                    if (0 < col && '1' == grid[row][col - 1]) {
                        dsu.union(cols * row + col, cols * row + col - 1);
                    }
                    if (rows > 1 + row && '1' == grid[1 + row][col]) {
                        dsu.union(cols * row + col, cols * (1 + row) + col);
                    }
                    if (cols > 1 + col && '1' == grid[row][1 + col]) {
                        dsu.union(cols * row + col, cols * row + 1 + col);
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
                        _parents[cols * row + col] = cols * row + col;
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

        public void union(int x, int y) {
            var px = find(x);
            var py = find(y);

            if (px != py) {
                --_connectedComponentsCount;

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
