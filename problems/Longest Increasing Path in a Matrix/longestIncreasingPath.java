class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;

        if (null == matrix || 0 == matrix.length) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] store = new int[rows][cols];

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                result = Math.max(result, dfs(matrix, row, col, store));
            }
        }

        return result;
    }

    int dfs(int[][] grid, int row, int col, int[][] store) {
        if (0 != store[row][col]) {
            return store[row][col];
        }

        int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (0 <= newRow && grid.length > newRow
               && 0 <= newCol && grid[0].length > newCol
               && grid[row][col] < grid[newRow][newCol]) {
                store[row][col] = Math.max(store[row][col], dfs(grid, newRow, newCol, store));
            }
        }

        ++store[row][col];

        return store[row][col];
    }
}
