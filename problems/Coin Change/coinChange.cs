public class Solution {
    public int CoinChange(int[] coins, int amount) {
        var dp = new int[1 + amount];

        Array.Fill(dp, int.MaxValue);

        for (var idx = 0; coins.Length > idx; ++idx) {
            var coin = coins[idx];

            for (var sum = 0; amount >= sum; ++sum) {
                if (0 == sum) {
                    dp[sum] = 0;
                } else {
                    var sumWithout = dp[sum];
                    var sumWith = sum >= coin && int.MaxValue != dp[sum - coin] ? 1 + dp[sum - coin] : int.MaxValue;
                    dp[sum] = Math.Min(sumWith, sumWithout);
                }
            }
        }

        return int.MaxValue == dp[amount] ? -1 : dp[amount];
    }
}
