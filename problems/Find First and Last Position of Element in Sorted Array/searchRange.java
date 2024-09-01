class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);

        if (0 > leftIdx) {
            return new int[] {-1, -1};
        }

        int rightIdx = binarySearch(nums, target, false);

        return new int[] {leftIdx, rightIdx};
    }

    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length;

        while (1 + left < right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                if (isLeft) {
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

        if (nums.length > left && nums[left] == target) {
            return left;
        } else if (nums.length > right && nums[right] == target) {
            return right;
        }

        return -1;
    }
}
