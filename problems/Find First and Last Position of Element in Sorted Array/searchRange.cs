public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        var left = getIndex(nums, target);

        if (left == nums.Length || target != nums[left]) {
            return new int[2] {-1, -1};
        }

        var right = getIndex(nums, target, false);

        return new int[2] {left, right - 1};
    }

    private int getIndex(int[] nums, int target, bool left = true) {
        var l = 0;
        var r = nums.Length;

        while (l < r) {
            var mid = l + ((r - l) >> 1);

            if (nums[mid] > target || (left && nums[mid] == target)) {
                r = mid;
            } else {
                l = 1 + mid;
            }
        }

        return l;
    }
}
