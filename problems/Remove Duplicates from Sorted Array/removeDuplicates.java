class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 1;
        int nonDuplicateIdx = 1;

        for(int idx = 0; nums.length > idx; ++idx) {
            if (0 != idx && nums[idx - 1] != nums[idx]) {
                nums[nonDuplicateIdx++] = nums[idx];
                ++result;
            }
        }

        return result;
    }
}
