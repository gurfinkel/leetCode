public class Solution {
    public IList<int> NumIslands2(int rows, int cols, int[][] positions) {
        var n = positions.Length;
        var result = new int[n];
        var grid = new bool[rows, cols];
        var dsu = new Dsu(1 + rows * cols);

        for (var i = 0; rows * cols > i; ++i) {
            dsu.union(i, rows * cols);
        }

        var connectedComponentsCount = 0;

        for (var i = 0; n > i; ++i) {
            var row = positions[i][0];
            var col = positions[i][1];

            if (!grid[row, col]) {
                var connections = 0;

                grid[row, col] = true;
                dsu.setParent(cols * row + col);

                if (0 < row && grid[row - 1, col]) {
                    connections+=dsu.union(cols*(row-1)+col,cols*row+col)?1:0;
                }
                if (0 < col && grid[row, col - 1]) {
                    connections+=dsu.union(cols*row-1+col,cols*row+col)?1:0;
                }
                if (rows > 1 + row && grid[1 + row, col]) {
                    connections+=dsu.union(cols*(1+row)+col,cols*row+col)?1:0;
                }
                if (cols > 1 + col && grid[row, 1 + col]) {
                    connections+=dsu.union(cols*row+1+col,cols*row+col)?1:0;
                }

                connectedComponentsCount -= (connections - 1);
            }

            result[i] = connectedComponentsCount;
        }

        return result.ToList();
    }

    private class Dsu {
        private readonly int[] _parents;
        private readonly int[] _ranks;

        public Dsu(int n) {
            _parents = new int[n];
            _ranks = new int[n];

            for (var i = 0; n > i; ++i) {
                _parents[i] = i;
            }
        }

        public int find(int x) {
            if (_parents[x] != x) {
                _parents[x] = find(_parents[x]);
            }

            return _parents[x];
        }

        public void setParent(int x) {
            var px = find(x);

            _parents[x] = x;
            --_ranks[px];
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

            return true;
        }
    }
}
