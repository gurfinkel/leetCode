class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int zeroCounter = 0;

        while (nums.length > right) {
            if (0 == nums[right]) {
                ++zeroCounter;
            }

            while (left <= right && k < zeroCounter) {
                zeroCounter -= 0 == nums[left++] ? 1 : 0;
            }

            result = Math.max(result, ++right - left);
        }

        return result;
    }
}
