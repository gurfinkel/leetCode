public class Solution {
    public int MissingElement(int[] nums, int k) {
        int n = nums.Length;
        int left = 0;
        int right = n - 1;

        if (k > missing(n - 1, nums)) {
            return nums[n - 1] + k - missing(n - 1, nums);
        }

        while (left != right) {
            int mid = left + ((right - left) >> 1);

            if (k > missing(mid, nums)) {
                left = 1 + mid;
            } else {
                right = mid;
            }
        }

        return nums[left - 1] + k - missing(left - 1, nums);
    }

    private int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }
}
