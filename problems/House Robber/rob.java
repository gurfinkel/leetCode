class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];

        return rodTopDown(nums, dp, 0);
    }

    private int rodTopDown(int[] nums, Integer[] dp, int idx) {
        if (nums.length <= idx) {
            return 0;
        }

        if (null == dp[idx]) {
            dp[idx] = Math.max(nums[idx] + rodTopDown(nums, dp, 2 + idx), rodTopDown(nums, dp, 1 + idx));
        }

        return dp[idx];
    }
}
