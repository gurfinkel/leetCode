public class Solution {
    public int CountSquares(int[][] matrix) {
        if (null == matrix || 0 == matrix.Length) {
            return 0;
        }

        int rows = matrix.Length;
        int cols = matrix[0].Length;
        int[] dp = new int[1 + cols];
        int count = 0;
        int tmp = 0;

        for (int i = 1; rows >= i; ++i) {
            for (int j = 1; cols >= j; ++j) {
                if (1 == matrix[i - 1][j - 1]) {
                    int curMin = 1 + Math.Min(Math.Min(dp[j-1],dp[j]), tmp);
                    tmp = dp[j];
                    dp[j] = curMin;
                    count += curMin;
                } else {
                    tmp = 0;
                    dp[j] = 0;
                }
            }
        }

        return count;
    }
}
