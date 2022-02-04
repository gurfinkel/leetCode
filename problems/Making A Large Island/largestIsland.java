class Solution {
    public int largestIsland(int[][] grid) {
        int result = 0;
        int n = grid.length;
        Dsu dsu = new Dsu(n * n);
        int zeros = n * n;

        for (int row = 0; n > row; ++row) {
            for (int col = 0; n > col; ++col) {
                if (1 == grid[row][col]) {
                    if (0 < row && 1 == grid[row - 1][col]) {
                        dsu.union(row * n + col, (row - 1) * n + col);
                    }
                    if (0 < col && 1 == grid[row][col - 1]) {
                        dsu.union(row * n + col, row * n + col - 1);
                    }
                    --zeros;
                }
            }
        }

        if (0 == zeros) {
            return n * n;
        }

        for (int row = 0; n > row; ++row) {
            for (int col = 0; n > col; ++col) {
                if (0 == grid[row][col]) {
                    HashSet<Integer> visitedParents = new HashSet<>();
                    int sum = 0;

                    if (0 < row && 1 == grid[row - 1][col]) {
                        int parent = dsu.find((row - 1) * n + col);

                        sum += dsu.ranks[parent];
                        visitedParents.add(parent);
                    }
                    if (0 < col && 1 == grid[row][col - 1]) {
                        int parent = dsu.find(row * n + col - 1);

                        if (!visitedParents.contains(parent)) {
                            sum += dsu.ranks[parent];
                            visitedParents.add(parent);
                        }
                    }
                    if (n - 1 > row && 1 == grid[1 + row][col]) {
                        int parent = dsu.find((1 + row) * n + col);

                        if (!visitedParents.contains(parent)) {
                            sum += dsu.ranks[parent];
                            visitedParents.add(parent);
                        }
                    }
                    if (n - 1 > col && 1 == grid[row][1 + col]) {
                        int parent = dsu.find(row * n + 1 + col);

                        if (!visitedParents.contains(parent)) {
                            sum += dsu.ranks[parent];
                            visitedParents.add(parent);
                        }
                    }

                    result = Math.max(result, 1 + sum);
                }
            }
        }

        return result;
    }

    class Dsu {
        int[] parents;
        int[] ranks;

        Dsu(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int idx = 0; n > idx; ++idx) {
                parents[idx] = idx;
                ranks[idx] = 1;
            }
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }

            return parents[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px != py) {
                if (ranks[px] > ranks[py]) {
                    parents[py] = px;
                    ranks[px] += ranks[py];
                } else {
                    parents[px] = py;
                    ranks[py] += ranks[px];
                }
            }
        }
    }
}
