class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[1 + amount][coins.length];
        int result = coinChangeTopDown(coins, dp, amount, 0);
        // int result = coinChangeRecursive(coins, amount, 0);

        return Integer.MAX_VALUE == result ? -1 : result;
    }

    private int coinChangeRecursive(int[] coins, int amount, int idx) {
        if (0 == amount) {
            return 0;
        }

        if (0 > amount || coins.length <= idx) {
            return Integer.MAX_VALUE;
        }

        int withCoin = Integer.MAX_VALUE;

        if (amount >= coins[idx]) {
            withCoin = coinChangeRecursive(coins, amount - coins[idx], idx);
        }

        int withoutCoin = coinChangeRecursive(coins, amount, 1 + idx);

        return Math.min(Integer.MAX_VALUE == withCoin ? withCoin : 1 + withCoin, withoutCoin);
    }

    private int coinChangeTopDown(int[] coins, Integer[][] dp, int amount, int idx) {
        if (0 == amount) {
            return 0;
        }

        if (0 > amount || coins.length <= idx) {
            return Integer.MAX_VALUE;
        }

        if (null == dp[amount][idx]) {
            int withCoin = Integer.MAX_VALUE;

            if (amount >= coins[idx]) {
                withCoin = coinChangeTopDown(coins, dp, amount - coins[idx], idx);
            }

            int withoutCoin = coinChangeTopDown(coins, dp, amount, 1 + idx);

            dp[amount][idx] = Math.min(Integer.MAX_VALUE == withCoin ? withCoin : 1 + withCoin, withoutCoin);
        }

        return dp[amount][idx];
    }
}
