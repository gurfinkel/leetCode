class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        if (k > missing(nums, n - 1)) {
            return nums[n - 1] + k - missing(nums, n - 1);
        }

        int left = 0;
        int right = n;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (k > missing(nums, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left] + k - missing(nums, left);
    }

    int missing(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }
}
