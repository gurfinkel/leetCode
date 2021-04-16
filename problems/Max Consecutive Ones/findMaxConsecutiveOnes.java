class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int lastOne = -1;

        for (int idx = 0; nums.length > idx; ++idx) {
            if (0 == nums[idx]) {
                lastOne = -1;
            } else {
                if (-1 == lastOne) {
                    lastOne = idx;
                }
                result = Math.max(result, 1 + idx - lastOne);
            }
        }

        return result;
    }
}
