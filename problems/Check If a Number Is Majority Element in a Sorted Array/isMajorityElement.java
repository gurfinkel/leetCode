class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int left = binarySearch(nums, target, true);

        if (-1 == left) {
            return false;
        }

        int right = binarySearch(nums, target, false);

        return nums.length / 2 < right - left + 1;
    }

    public int binarySearch(int[] nums, int target, boolean leftmost) {
        int left = 0;
        int right = nums.length;

        while (left + 1 < right) {
            int mid = (right + left) / 2;

            if (nums[mid] == target) {
                if (leftmost) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        if (right < nums.length && nums[right] == target) {
            return right;
        }

        return -1;
    }
}
