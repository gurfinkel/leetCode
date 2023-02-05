class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[Math.max(3, 1 + n)];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int idx = 3; n >= idx; ++idx) {
            dp[idx] = dp[idx - 3] + dp[idx - 2] + dp[idx - 1];
        }

        return dp[n];
    }
}
