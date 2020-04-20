public class Solution {
    public bool CanPartition(int[] nums) {
        var n = nums.Length;
        var totalSum = nums.Sum();

        if (1 == (totalSum & 1)) {
            return false;
        }

        var halfOfTotalSum = totalSum >> 1;

        Array.Sort(nums, (a, b) => b - a);
        return hasSumDfs(nums, halfOfTotalSum);

        // return hasSubsetSumDp(nums, halfOfTotalSum);
    }

    private bool hasSumDp(int[] arr, int halfOfTotalSum) {
        var n = arr.Length;
        var dp = new bool[1 + halfOfTotalSum, 1 + n];

        for (var sum = 0; halfOfTotalSum >= sum; ++sum) {
            for (var idx = 0; n > idx; ++idx) {
                dp[sum, 1 + idx] = 0 == sum || dp[sum, idx] || 0 <= sum - arr[idx] && dp[sum - arr[idx], idx];
            }
        }

        return dp[halfOfTotalSum, n];
    }

    private bool hasSumDfs(int[] nums, int target, int i = 0, int sumL = 0, int sumR = 0) {
        if (nums.Length == i){
            return sumL == sumR;
        }

        return sumL + nums[i] <= target && hasSumDfs(nums, target, 1 + i, sumL + nums[i], sumR)
            || sumR + nums[i] <= target && hasSumDfs(nums, target, 1 + i, sumL, sumR + nums[i]);
    }
}
