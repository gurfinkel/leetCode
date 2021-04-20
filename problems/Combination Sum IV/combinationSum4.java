class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[1 + target];

        dp[0] = 1;

        for (int sum = 1; target >= sum; ++sum) {
            for (int num : nums) {
                if (0 <= sum - num) {
                    dp[sum] += dp[sum - num];
                }
            }
        }

        return dp[target];
    }
}
