class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int idx = n - 1;

        while (0 <= idx) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[idx--] = nums[left] * nums[left];
                ++left;
            } else {
                result[idx--] = nums[right] * nums[right];
                --right;
            }
        }

        return result;
    }
}
