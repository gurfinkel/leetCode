class Solution {
    public int removeDuplicates(int[] nums) {
        int lastIdx = 1;
        int counter = 1;

        for (int idx = 1; nums.length > idx; ++idx) {
            if (nums[idx - 1] == nums[idx]) {
                ++counter;
            } else {
                counter = 1;
            }

            nums[lastIdx] = nums[idx];

            if (3 > counter) {
               ++lastIdx;
            }
        }

        return lastIdx;
    }
}
