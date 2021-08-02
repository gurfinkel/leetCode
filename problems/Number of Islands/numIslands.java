class Solution {
    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length) {
            return 0;
        }

        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if ('1' == grid[row][col]) {
                    ++result;
                    dfs(grid, row, col);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (0 > row || 0 > col || rows <= row || cols <= col || '0' == grid[row][col]) {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, 1 + row, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, 1 + col);
    }
}
