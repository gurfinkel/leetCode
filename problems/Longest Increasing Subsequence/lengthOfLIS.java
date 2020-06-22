class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][1 + n];

        return getLisTopDown(nums, dp, 0, -1);
    }

    private int getLisTopDown(int[] nums, Integer[][] dp, int currIdx, int prevIdx) {
        if (nums.length == currIdx) {
            return 0;
        }

        if (null == dp[currIdx][1 + prevIdx]) {
            int lenWith = -1 == prevIdx || nums[currIdx] > nums[prevIdx] ? 1 + getLisTopDown(nums, dp, 1 + currIdx, currIdx) : 0;
            int lenWithout = getLisTopDown(nums, dp, 1 + currIdx, prevIdx);

            dp[currIdx][1 + prevIdx] = Math.max(lenWith, lenWithout);
        }

        return dp[currIdx][1 + prevIdx];
    }

    private int getLisLenRecursive(int[] nums, int currIdx, int prevIdx) {
        if (nums.length == currIdx) {
            return 0;
        }

        int lenWith = -1 == prevIdx || nums[currIdx] > nums[prevIdx] ? 1 + getLisLenRecursive(nums, 1 + currIdx, currIdx) : 0;
        int lenWithout = getLisLenRecursive(nums, 1 + currIdx, prevIdx);

        return Math.max(lenWith, lenWithout);
    }
}
