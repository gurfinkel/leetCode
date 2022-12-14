class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int row = 0; rows > row; ++row) {
            Arrays.fill(dp[row], Integer.MAX_VALUE);
        }

        for (int col = 0; matrix[0].length > col; ++col) {
            dfs(matrix, 0, col, dp);
        }

        for (int col = 0; matrix[0].length > col; ++col) {
            result = Math.min(result, dp[0][col]);
        }

        return result;
    }

    int dfs(int[][] matrix, int row, int col, int[][] dp) {
        if (matrix.length <= row) {
            return 0;
        }

        if (Integer.MAX_VALUE == dp[row][col]) {
            int left = 0 < col ? dfs(matrix, 1 + row, col - 1, dp) : Integer.MAX_VALUE;
            int mid = dfs(matrix, 1 + row, col, dp);
            int right = matrix[0].length > 1 + col ? dfs(matrix, 1 + row, 1 + col, dp) : Integer.MAX_VALUE;

            dp[row][col] = matrix[row][col] + Math.min(Math.min(left, right), mid);
        }

        return dp[row][col];
    }
}
