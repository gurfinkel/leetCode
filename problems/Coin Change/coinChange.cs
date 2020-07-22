public class Solution {
    public int CoinChange(int[] coins, int amount) {
        return CoinChangeBottomUp(coins, amount);
    }

    public int CoinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[1 + amount];

        Array.Fill(dp, int.MaxValue);

        foreach (int coin in coins) {
            for (int sum = 0; amount >= sum; ++sum) {
                if (0 == sum) {
                    dp[sum] = 0;
                } else if (coin <= sum) {
                    var sumWithout = dp[sum];
                    var sumWith = int.MaxValue == dp[sum - coin] ? int.MaxValue : 1 + dp[sum - coin];

                    dp[sum] = Math.Min(sumWith, sumWithout);
                }
            }
        }

        return int.MaxValue == dp[amount] ? -1 : dp[amount];
    }
}
