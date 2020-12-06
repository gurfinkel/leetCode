class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] != nums[mid - 1] && (1 + mid == nums.length || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            } else if ((1 == (mid & 1) && nums[mid] == nums[mid - 1]) || (0 == (mid & 1) && nums[mid] == nums[mid + 1])) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
