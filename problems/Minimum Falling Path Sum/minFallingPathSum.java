class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int row = 0; rows > row; ++row) {
            Arrays.fill(dp[row], Integer.MAX_VALUE);
        }

        for (int col = 0; matrix[0].length > col; ++col) {
            dfs(matrix, 0, col, 0, dp);
        }

        return minSum;
    }

    int minSum = Integer.MAX_VALUE;

    void dfs(int[][] matrix, int row, int col, int sum, int[][] dp) {
        if (matrix.length <= row) {
            if (Integer.MAX_VALUE == minSum) {
                minSum = sum;
            } else {
                minSum = Math.min(minSum, sum);
            }

            return;
        }

        if (0 > col || matrix[0].length <= col) {
            return;
        }

        sum += matrix[row][col];

        if (sum < dp[row][col]) {
            dp[row][col] = sum;

            dfs(matrix, 1 + row, col - 1, sum, dp);
            dfs(matrix, 1 + row, col, sum, dp);
            dfs(matrix, 1 + row, 1 + col, sum, dp);
        }
    }
}
