public class Solution {
    public int SingleNonDuplicate(int[] nums) {
        if (null == nums || 0 == nums.Length || 0 == (nums.Length & 1)) {
            return -1;
        }

        var n = nums.Length;
        var l = 0;
        var r = n - 1;

        while (l < r) {
            var mid = l + ((r - l) >> 1);

            if (1 == (mid & 1)) {
                --mid;
            }

            if (nums[mid] == nums[1 + mid]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
