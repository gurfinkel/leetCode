class Solution {
    public int shortestDistance(int[][] grid) {
        int result = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distances = new int[rows][cols];
        int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> bfs = new LinkedList<>();
        int builderCounter = 0;

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (1 == grid[row][col]) {
                    int distance = 1;

                    result = Integer.MAX_VALUE;
                    bfs.add(new int[] {row, col});

                    while (!bfs.isEmpty()) {
                        for (int idx = bfs.size(); 0 < idx; --idx) {
                            int[] item = bfs.poll();

                            for (int[] direction : directions) {
                                int newRow = item[0] + direction[0];
                                int newCol = item[1] + direction[1];

                                if (0 <= newRow && rows > newRow
                                    && 0 <= newCol && cols > newCol
                                    && builderCounter == grid[newRow][newCol]) {
                                    --grid[newRow][newCol];
                                    bfs.add(new int[] {newRow, newCol});
                                    distances[newRow][newCol] += distance;
                                    result = Math.min(result, distances[newRow][newCol]);
                                }
                            }
                        }

                        ++distance;
                    }

                    --builderCounter;
                }
            }
        }

        return Integer.MAX_VALUE == result ? -1 : result;
    }
}
