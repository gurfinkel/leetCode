public class Solution {
    public int TriangleNumber(int[] nums) {
        var n = nums.Length;
        var result = 0;

        Array.Sort(nums);

        for (var i = 0; n - 2 > i; ++i) {
            if (0 == nums[i]) {
                continue;
            }

            var k = i + 2;

            for (var j = 1 + i; n - 1 > j; ++j) {
                while (n > k && nums[i] + nums[j] > nums[k]) { ++k; }
                result += k - j - 1;
            }
        }

        return result;
    }
}
