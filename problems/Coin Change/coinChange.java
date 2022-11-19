class Solution {
    public int coinChange(int[] coins, int amount) {
        // return coinChangeBfs(coins, amount);
        return coinChangeBottomUp(coins, amount);
    }

    int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[1 + amount];

        Arrays.fill(dp, 1 + amount);
        dp[0] = 0;

        for (int idx = 0; coins.length > idx; ++idx) {
            for (int sum = coins[idx]; amount >= sum; ++sum) {
                dp[sum] = Math.min(dp[sum], 1 + dp[sum - coins[idx]]);
            }
        }

        return 1 + amount == dp[amount] ? -1 : dp[amount];
    }

    int coinChangeBfs(int[] coins, int amount) {
        int result = 0;
        Queue<Integer> bfs = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        if (0 >= amount) {
            return result;
        }

        bfs.add(amount);

        while (!bfs.isEmpty()) {
            ++result;

            for (int idx = bfs.size(); 0 < idx; --idx) {
                int item = bfs.poll();

                for (int coin : coins) {
                    if (item == coin) {
                        return result;
                    } else if (item > coin && !visited.contains(item - coin)) {
                        bfs.add(item - coin);
                        visited.add(item - coin);
                    }
                }
            }
        }

        return -1;
    }
}
