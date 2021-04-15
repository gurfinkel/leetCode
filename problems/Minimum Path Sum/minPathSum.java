class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (0 == row && 0 == col) {
                    dp[col] = grid[row][col];
                } else  {
                    int fromUp = 0 < row ? dp[col] : Integer.MAX_VALUE;
                    int fromLeft = 0 < col ? dp[col - 1] : Integer.MAX_VALUE;

                    dp[col] = grid[row][col] + Math.min(fromUp, fromLeft);
                }
            }
        }

        return dp[cols - 1];
    }
}
