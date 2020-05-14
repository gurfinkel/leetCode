class Solution {
    public void moveZeroes(int[] nums) {
        for (int idx = 0, nonZeroIdx = 0; nums.length > idx; ++idx) {
            if (0 != nums[idx]) {
                nums[nonZeroIdx++] = nums[idx];
            }
            if (idx >= nonZeroIdx) {
                nums[idx] = 0;
            }
        }
    }
}
