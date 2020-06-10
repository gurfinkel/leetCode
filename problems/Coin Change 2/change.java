class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][1 + amount];

        return changeTopDown(amount, coins, dp, 0);
    }

    private int changeTopDown(int amount, int[] coins, Integer[][] dp, int idx) {
        if (0 == amount) {
            return 1;
        }

        if (coins.length <= idx) {
            return 0;
        }

        if (null == dp[idx][amount]) {
            int sumWith = amount >= coins[idx] ? changeTopDown(amount-coins[idx], coins, dp, idx) : 0;
            int sumWithout = changeTopDown(amount, coins, dp, 1 + idx);
            dp[idx][amount] = sumWith + sumWithout;
        }

        return dp[idx][amount];
    }
}
