class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (1 == (mid & 1)) {
                --mid;
            }

            if (nums[mid] == nums[1 + mid]) {
                left = 2 + mid;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
