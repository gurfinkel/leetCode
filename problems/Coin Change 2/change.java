class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int item = coin; amount >= item; ++item) {
                dp[item] += dp[item - coin];
            }
        }

        return dp[amount];
    }
}
