public class Solution {
    public int LengthOfLIS(int[] nums) {
        return lisDp(nums);
    }

    private int lisDpAndBs(int[] nums) {
        int[] dp = new int[nums.Length];
        int len = 0;

        foreach (int num in nums) {
            int i = Array.BinarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    private int lisDp(int[] nums) {
        if (null == nums || 0 == nums.Length) {
            return 0;
        }

        var n = nums.Length;
        var dp = new int[n];
        var result = 1;

        for (var i = 0; n > i; ++i) {
            for (var j = 0; i > j; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.Max(dp[i], dp[j]);
                }
            }
            ++dp[i];
            result = Math.Max(result, dp[i]);
        }

        return result;
    }
}
