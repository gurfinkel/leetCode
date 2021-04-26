class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        int sum = 0;

        for (int idx = 0; n > idx; ++idx) {
            sum += nums[idx];

            while (target <= sum) {
                result = Math.min(result, 1 + idx - left);
                sum -= nums[left++];
            }
        }

        return (Integer.MAX_VALUE == result) ? 0 : result;
    }
}
