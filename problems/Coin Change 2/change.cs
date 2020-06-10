public class Solution {
    public int Change(int amount, int[] coins) {
        int[] dp = new int[1 + amount];

        dp[0] = 1;

        foreach (int coin in coins) {
            for (int sum = 1; amount >= sum; ++sum) {
                if (sum >= coin) {
                    dp[sum] += dp[sum - coin];
                }
            }
        }

        return dp[amount];
    }
}
