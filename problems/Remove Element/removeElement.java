class Solution {
    public int removeElement(int[] nums, int val) {
        int currIdx = 0;

        for (int idx = 0; nums.length > idx; ++idx) {
            nums[currIdx] = nums[idx];

            if (val != nums[currIdx]) {
                ++currIdx;
            }
        }

        return currIdx;
    }
}
