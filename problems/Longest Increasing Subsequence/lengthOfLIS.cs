public class Solution {
    public int LengthOfLIS(int[] nums) {
        return getLisLenDpAndBs(nums);
    }

    private int getLisLenDpAndBs(int[] nums) {
        int[] dp = new int[nums.Length];
        int result = 0;

        foreach (int num in nums) {
            int i = Array.BinarySearch(dp, 0, result, num);

            if (0 > i) {
                i = -(1 + i);
            }

            dp[i] = num;

            if (result == i) {
                ++result;
            }
        }

        return result;
    }

    private int getLisLenBottomUp(int[] nums) {
        if (null == nums || 0 == nums.Length) {
            return 0;
        }

        int n = nums.Length;
        int[] dp = new int[n];
        int result = 1;

        Array.Fill(dp, 1);

        for (int i = 1; n > i; ++i) {
            for (int j = 0; i > j; ++j) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                    result = Math.Max(result, dp[i]);
                }
            }
        }

        return result;
    }
}
