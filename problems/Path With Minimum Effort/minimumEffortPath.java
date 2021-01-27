class Solution {
    public int minimumEffortPath(int[][] heights) {
        if (1 == heights.length && 1 == heights[0].length) {
            return 0;
        }

        int rows = heights.length;
        int cols = heights[0].length;
        Dsu dsu = new Dsu(1 + rows * cols);
        List<Edge> edgeList = new ArrayList<>();

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (0 < row) {
                    edgeList.add(new Edge(row * cols + col,
                            (row - 1) * cols + col,
                            Math.abs(heights[row][col] - heights[row - 1][col]))
                    );
                }
                if (0 < col) {
                    edgeList.add(new Edge(row * cols + col,
                            row * cols + col - 1,
                            Math.abs(heights[row][col] - heights[row][col - 1]))
                    );
                }
            }
        }

        Collections.sort(edgeList, (e1, e2) -> e1.difference - e2.difference);

        for (int idx = 0; edgeList.size() > idx; ++idx) {
            int x = edgeList.get(idx).x;
            int y = edgeList.get(idx).y;

            dsu.union(x, y);

            if (dsu.find(0) == dsu.find(rows * cols - 1)) {
                return edgeList.get(idx).difference;
            }
        }

        return -1;
    }
}

class Dsu {
    private final int[] _parents;
    private final int[] _ranks;

    public Dsu(int n) {
        _parents = new int[n];
        _ranks = new int[n];

        for (int i = 0; n > i; ++i) {
            _parents[i] = i;
        }
    }

    public int find(int x) {
        if (_parents[x] != x) {
            _parents[x] = find(_parents[x]);
        }

        return _parents[x];
    }

    public void union(int x, int y) {
        var px = find(x);
        var py = find(y);

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

class Edge {
    int x;
    int y;
    int difference;

    public Edge(int x, int y, int difference) {
        this.x = x;
        this.y = y;
        this.difference = difference;
    }
}
