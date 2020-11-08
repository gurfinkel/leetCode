public class Solution {
    public int TwoSumLessThanK(int[] A, int K) {
        int result = -1;

        Array.Sort(A);

        for (int idx = 1; A.Length > idx; ++idx) {
            int item = binarySearchForTargetOrLess(A, K - A[idx] - 1, idx - 1);

            if (-1 != item) {
                result = Math.Max(result, item + A[idx]);
            }
        }

        return result;
    }

    private int binarySearchForTargetOrLess(int[] nums, int target, int right, int left = 0) {
        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);

            if (target == nums[mid]) {
                return nums[mid];
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (target >= nums[right]) {
            return nums[right];
        }

        if (target >= nums[left]) {
            return nums[left];
        }

        return -1;
    }
}
