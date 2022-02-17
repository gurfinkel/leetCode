class Solution {
    public int largestIsland(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Dsu dsu = new Dsu(rows * cols);
        int zeros = rows * cols;
        int[][] directions = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (1 == grid[row][col]) {
                    for (int idx = 0; 2 > idx; ++idx) {
                        int newRow = row + directions[idx][0];
                        int newCol = col + directions[idx][1];

                        if (rows > newRow
                            && cols > newCol
                            && 1 == grid[newRow][newCol]) {
                            dsu.union(row * cols + col, newRow * cols + newCol);
                        }
                    }
                    --zeros;
                }
            }
        }

        if (0 == zeros) {
            return rows * cols;
        } else if (rows * cols == zeros) {
            return 1;
        }

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (0 == grid[row][col]) {
                    int sum = 0;
                    HashSet<Integer> visitedParents = new HashSet<>();

                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];

                        if (0 <= newRow
                            && 0 <= newCol
                            && rows > newRow
                            && cols > newCol
                            && 1 == grid[newRow][newCol]) {
                            int parentId = dsu.find(newRow * cols + newCol);

                            if (!visitedParents.contains(parentId)) {
                                sum += dsu.ranks[parentId];
                                visitedParents.add(parentId);
                                result = Math.max(result, 1 + sum);
                            }
                        }
                    }
                }
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

        public int find(int a) {
            if (parents[a] != a) {
                parents[a] = find(parents[a]);
            }

            return parents[a];
        }

        public void union(int a, int b) {
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
