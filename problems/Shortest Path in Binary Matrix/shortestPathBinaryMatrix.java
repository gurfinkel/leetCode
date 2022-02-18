class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> bfs = new LinkedList<>();
        int[][] directions = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        if (0 != grid[0][0] || 0 != grid[rows - 1][cols - 1]) {
            return -1;
        }

        bfs.add(new int[]{0,0});
        grid[0][0] = -1;

        while (!bfs.isEmpty()) {
            ++result;
            for (int idx = bfs.size(); 0 < idx; --idx) {
                int[] items = bfs.poll();
                int row = items[0];
                int col = items[1];

                if (rows == 1 + row && cols == 1 + col) {
                    return result;
                }

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (0 <= newRow && rows > newRow
                       && 0 <= newCol && cols > newCol
                       && 0 == grid[newRow][newCol]) {
                        bfs.add(new int[] {newRow, newCol});
                        grid[newRow][newCol] = -1;
                    }
                }
            }
        }

        return -1;
    }
}
