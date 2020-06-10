class Solution {
    public int coinChange(int[] coins, int amount) {
        var n = coins.length;
        var dp = new Integer[n][1 + amount];

        var result = fillDp(coins, amount, dp, 0);

        return Integer.MAX_VALUE == result ? -1 : result;
    }

    private int fillDp(int[] coins, int amount, Integer[][] dp, int idx) {
        if (0 == amount) {
            return 0;
        }

        if (0 == coins.length || coins.length <= idx) {
            return Integer.MAX_VALUE;
        }


        if (null == dp[idx][amount]) {
            var amountWith = Integer.MAX_VALUE;

            if (amount >= coins[idx]) {
                amountWith = fillDp(coins, amount - coins[idx], dp, idx);
                amountWith += Integer.MAX_VALUE == amountWith ? 0 : 1;
            }

            var amountWithout = fillDp(coins, amount, dp, 1 + idx);

            dp[idx][amount] = Math.min(amountWith, amountWithout);
        }

        return dp[idx][amount];
    }
}
