class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left + 1 < right) {
            int mid = (right + left) / 2;

            if (0 <= mid && nums[mid - 1] < nums[mid] && mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
