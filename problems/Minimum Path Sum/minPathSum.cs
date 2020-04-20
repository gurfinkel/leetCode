public class Solution {
    public int MinPathSum(int[][] grid) {
        var dp = new int[grid[0].Length];

        for (int i = grid.Length - 1; i >= 0; i--) {
            for (int j = grid[0].Length - 1; j >= 0; j--) {
                if(i == grid.Length - 1 && j != grid[0].Length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].Length - 1 && i != grid.Length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].Length - 1 && i != grid.Length - 1)
                    dp[j] = grid[i][j] + Math.Min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }

        return dp[0];
    }
}
