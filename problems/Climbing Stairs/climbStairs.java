class Solution {
    public int climbStairs(int n) {
        var dp = new int[1 + n];

        return countStairs(dp, n);
    }

    private int countStairs(int[] dp, int n) {
        if (0 == n || 1 == n) {
            return 1;
        }

        if (0 == dp[n]) {
            dp[n] = countStairs(dp, n - 1) + countStairs(dp, n - 2);
        }

        return dp[n];
    }
}
