class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        int n = nums.length;

        for (int num : nums) {
            result += Math.abs(nums[n / 2] - num);
        }

        return result;
    }
}
