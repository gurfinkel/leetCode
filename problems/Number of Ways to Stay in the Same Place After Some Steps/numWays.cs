public class Solution {
    public int NumWays(int steps, int arrLen) {
        var mod = 1000000007;
        var maxPos = Math.Min(steps, arrLen);
        var dp = new int [1 + steps, 1 + maxPos];

        dp[0, 0] = 1;

        for (var i = 1; steps >= i; ++i) {
            for (var j = 0; maxPos > j; ++j) {
                if (0 < dp[i - 1, j]) {
                    dp[i, j] = (dp[i, j] + dp[i - 1, j]) % mod;
                }
                if (1 + j < arrLen && 0 < dp[i - 1, 1 + j]) {
                    dp[i, j] = (dp[i, j] + dp[i - 1, 1 + j]) % mod;
                }
                if (0 < j && 0 < dp[i - 1, j - 1]) {
                    dp[i, j] = (dp[i, j] + dp[i - 1, j - 1]) % mod;
                }
            }
        }

        return dp[steps, 0];
    }
}
