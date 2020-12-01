class Solution {
    public int jump(int[] nums) {
        return jumpBottomUp(nums);
    }

    private int jumpBottomUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int idx = 0; n > idx; ++idx) {
            dp[idx] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int idx = 0; n > idx; ++idx) {
            int lastIdx = Math.min(n - 1, idx + nums[idx]);
            int nextIdx = idx;

            while (++nextIdx <= lastIdx) {
                dp[nextIdx] = Math.min(1 + dp[idx], dp[nextIdx]);
            }
        }

        return dp[n - 1];
    }
}
