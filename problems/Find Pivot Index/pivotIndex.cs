public class Solution {
    public int PivotIndex(int[] nums) {
        if (null == nums || 0 == nums.Length) {
            return -1;
        }

        var n = nums.Length;
        var leftToRightSums = new int[1 + n];
        var rightToLeftSums = new int[1 + n];

        for (var i = 1; n >= i; ++i) {
            leftToRightSums[i] = nums[i - 1] + leftToRightSums[i - 1];
            rightToLeftSums[n - i] = nums[n - i] + rightToLeftSums[n - i + 1];
        }

        for (var i = 0; n > i; ++i) {
            if (leftToRightSums[i] == rightToLeftSums[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
