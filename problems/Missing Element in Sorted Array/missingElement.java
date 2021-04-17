class Solution {
    public int missingElement(int[] nums, int k) {
        int idx = 0;
        int result = nums[idx];

        while (0 < k) {
            if (nums.length > idx && nums[idx] == result) {
                ++idx;
            } else {
                --k;
            }

            ++result;
        }

        return result - 1;
    }
}
