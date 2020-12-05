class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int result = 1;
        int anchor = 0;

        for (int idx = 1; nums.length > idx; ++idx) {
            if (nums[idx - 1] >= nums[idx]) {
                anchor = idx;
            }

            result = Math.max(result, 1 + idx - anchor);
        }

        return result;
    }
}
