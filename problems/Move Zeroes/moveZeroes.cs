class Solution {
    public void moveZeroes(int[] nums) {
        var nonZeroIdx = 0;

        for (var idx = 0; nums.length > idx; ++idx) {
            if (0 != nums[idx]) {
                nums[nonZeroIdx++] = nums[idx];
            }
            if (idx >= nonZeroIdx) {
                nums[idx] = 0;
            }
        }
    }
}
