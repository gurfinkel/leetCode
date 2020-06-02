class Solution {
    public boolean canPartition(int[] nums) {
        // return canPartitionTopDown(nums);
        return canPartitionBottomUp(nums);
    }

    private boolean canPartitionTopDown(int[] nums) {
        int n = nums.length;
        int allSum = 0;

        for (int num : nums) {
            allSum += num;
        }

        if (1 == (allSum & 1)) {
            return false;
        }

        int halfSum = allSum >> 1;
        Boolean[] dp = new Boolean[1 + halfSum];

        return checkSum(nums, halfSum, 0, dp);
    }

    private boolean checkSum(int[] nums, int sum, int idx, Boolean[] dp) {
        if (0 > sum || nums.length <= idx) {
            return false;
        }

        if (0 == sum) {
            return true;
        }

        if (null == dp[sum]) {
            boolean isSumWith = sum >= nums[idx] && checkSum(nums, sum - nums[idx], 1 + idx, dp);
            boolean isSumWithout = checkSum(nums, sum, 1 + idx, dp);
            dp[sum] = isSumWith || isSumWithout;
        }

        return dp[sum];
    }

    private boolean canPartitionBottomUp(int[] nums) {
        int n = nums.length;
        int allSum = 0;

        for (int num : nums) {
            allSum += num;
        }

        if (1 == (allSum & 1)) {
            return false;
        }

        int halfSum = allSum >> 1;
        boolean[] dp = new boolean[1 + halfSum];

        for (int idx = 0; n > idx; ++idx) {
            for (int sum = halfSum; 0 <= sum; --sum) {
                if (sum == nums[idx] || (sum > nums[idx] && dp[sum - nums[idx]])) {
                    dp[sum] = true;
                }
            }
        }

        return dp[halfSum];
    }
}
