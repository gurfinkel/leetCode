public class Solution {
    public bool CanPartition(int[] nums) {
        var allSum = nums.Sum();

        if (1 == (allSum & 1)) {
            return false;
        }

        var halfSum = allSum >> 1;
        var dp = new bool[1 + halfSum];

        foreach (var num in nums) {
            for (var sum = halfSum; 0 < sum; --sum) {
                if (sum == num || (sum > num && dp[sum - num])) {
                    dp[sum] = true;
                }
            }
        }

        return dp[halfSum];
    }
}
