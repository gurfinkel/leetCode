class Solution {
    public int knightDialer(int n) {
        int MOD = 1_000_000_007;
        int[][] moves = new int[][]{
            {4,6},{6,8},{7,9},{4,8},{3,9,0},
            {},{1,7,0},{2,6},{1,3},{2,4}};

        long result = 0;
        int[][] dp = new int[2][10];

        Arrays.fill(dp[0], 1);

        for (int hops = 0; n-1 > hops; ++hops) {
            Arrays.fill(dp[~hops & 1], 0);

            for (int node = 0; 10 > node; ++node) {
                for (int nei: moves[node]) {
                    dp[~hops & 1][nei] += dp[hops & 1][node];
                    dp[~hops & 1][nei] %= MOD;
                }
            }
        }

        for (int x: dp[~n & 1]) {
            result += x;
        }

        return (int) (result % MOD);
    }
}
