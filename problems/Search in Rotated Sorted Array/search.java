class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int indexInLeftPart = ascendingBinarySearch(nums, 0, pivot, target);

        if (-1 != indexInLeftPart) {
            return indexInLeftPart;
        }

        int indexInRightPart = ascendingBinarySearch(nums, pivot, nums.length, target);

        if (-1 != indexInRightPart) {
            return indexInRightPart;
        }

        return -1;
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left + 1 < right) {
            int mid = (right + left) / 2;

            if (nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[left] < nums[mid]) {
                left = mid;
            } else {
            right = mid;
            }
        }

        return left;
    }

    private int ascendingBinarySearch(int[] nums, int left, int right, int target) {
        while (left + 1 < right) {
            int mid = (right + left) / 2;

            if (nums[mid] == target) {
                return mid;
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
