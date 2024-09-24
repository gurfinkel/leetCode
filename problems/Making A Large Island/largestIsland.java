class Solution {
    public int largestIsland(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Dsu dsu = new Dsu(rows * cols);
        int zeroCount = rows * cols;
        int[][] directions = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (1 == grid[row][col]) {
                    if (rows > 1 + row && 1 == grid[1 + row][col]) {
                        dsu.union(cols * row + col, (cols * (1 + row)) + col);
                    }
                    if (cols > 1 + col && 1 == grid[row][1 + col]) {
                        dsu.union(cols * row + col, (cols * row) + (1 + col));
                    }
                    --zeroCount;
                }
            }
        }

        if (0 == zeroCount) {
            return rows * cols;
        } else if (rows * cols == zeroCount) {
            return 1;
        }
        
        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (0 == grid[row][col]) {
                    int sum = 1;
                    HashSet<Integer> visitedParents = new HashSet<>();

                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];

                        if (0 <= newRow && rows > newRow && 0 <= newCol && cols > newCol && 1 == grid[newRow][newCol]) {
                            int parent = dsu.find(cols * newRow + newCol);

                            if (!visitedParents.contains(parent)) {
                                sum += dsu.ranks[parent];
                                visitedParents.add(parent);
                            }
                        }
                    }
                    
                    result = Math.max(result, sum);
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
