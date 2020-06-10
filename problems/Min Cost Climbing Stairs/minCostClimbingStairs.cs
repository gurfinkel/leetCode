public class Solution {
    public int MinCostClimbingStairs(int[] cost) {
        var dp = new int[1 + cost.Length];

        for (var i = 2; cost.Length >= i; ++i) {
            dp[i] = Math.Min(cost[i - 2] + dp[i - 2], cost[i - 1] + dp[i - 1]);
        }

        return dp[cost.Length];
    }
}
