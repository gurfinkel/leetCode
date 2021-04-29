class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (target > sum || 1 == ((sum + target) & 1)) {
            return 0;
        }

        sum = (sum + target) >> 1;

        int[] dp = new int[1 + sum];

        dp[0] = 1;

        for (int num : nums) {
            for (int idx = sum; num <= idx; --idx) {
                dp[idx] += dp[idx - num];
            }
        }

        return dp[sum];
    }
}
