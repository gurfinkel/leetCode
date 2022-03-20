class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length];

        return dp(0, days, costs, memo);
    }

    public int dp(int idx, int[] days, int[] costs, Integer[] memo) {
        if (days.length <= idx) {
            return 0;
        }

        if (null != memo[idx]) {
            return memo[idx];
        }


        int[] durations = new int[]{1, 7, 30};
        int ans = Integer.MAX_VALUE;
        int i = idx;

        for (int k = 0; 3 > k; ++k) {
            while (i < days.length && days[i] < days[idx] + durations[k]) {
                ++i;
            }

            ans = Math.min(ans, dp(i, days, costs, memo) + costs[k]);
        }

        memo[idx] = ans;

        return ans;
    }
}
