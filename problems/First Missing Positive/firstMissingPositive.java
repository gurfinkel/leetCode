class Solution {
    public int firstMissingPositive(int[] nums) {
        int result = 1;

        Arrays.sort(nums);

        for (int idx = 0; nums.length > idx; ++idx) {
            int num = nums[idx];

            if (0 >= num || (0 < idx && nums[idx - 1] == num)) {
                continue;
            }
            if (num != result) {
                return result;
            }
            result = 1 + num;
        }

        return result;
    }
}
