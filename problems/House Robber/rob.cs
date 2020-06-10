public class Solution {
    public int Rob(int[] nums) {
        if (null == nums || 0 == nums.Length) {
            return 0;
        }

        int prev = nums[0];
        int prevPrev = 0;

        for (int i = 1; nums.Length > i; ++i) {
            int curr = Math.Max(nums[i] + prevPrev, prev);
            prevPrev = prev;
            prev = curr;
        }

        return prev;
    }
}
