class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        minCostTopDown(cost, dp, 0);

        return Math.min(dp[0], dp[1]);
    }

    private int minCostTopDown(int[] cost, int[] dp, int idx) {
        if (cost.length <= idx) {
            return 0;
        }

        if (0 == dp[idx]) {
            dp[idx] = cost[idx] + Math.min(minCostTopDown(cost, dp, 1+idx), minCostTopDown(cost, dp, 2+idx));
        }

        return dp[idx];
    }
}
