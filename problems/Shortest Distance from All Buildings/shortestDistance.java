class Solution {
    public int shortestDistance(int[][] grid) {
        int result = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> bfs = new LinkedList<>();
        int[][] distances = new int[rows][cols];
        int emptyLandCounter = 0;
        int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (1 == grid[row][col]) {
                    int distance = 0;

                    result = Integer.MAX_VALUE;
                    bfs.add(new int[] {row, col});

                    while (!bfs.isEmpty()) {
                        ++distance;

                        for (int idx = bfs.size(); 0 < idx; --idx) {
                            int[] curr = bfs.poll();

                            for (int[] direction : directions) {
                                int newRow = curr[0] + direction[0];
                                int newCol = curr[1] + direction[1];

                                if (0 <= newRow && 0 <= newCol
                                    && rows > newRow && cols > newCol
                                    && emptyLandCounter == grid[newRow][newCol]) {
                                    --grid[newRow][newCol];
                                    distances[newRow][newCol] += distance;
                                    result = Math.min(result, distances[newRow][newCol]);
                                    bfs.add(new int[] {newRow, newCol});
                                }
                            }
                        }
                    }

                    --emptyLandCounter;
                }
            }
        }

        return Integer.MAX_VALUE == result ? -1 : result;
    }
}
