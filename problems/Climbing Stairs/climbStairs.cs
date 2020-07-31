public class Solution {
    public int ClimbStairs(int n) {
        return climbStairsConstantSpace(n);
    }

    public int climbStairsConstantSpace(int n) {
        var minusOne = 1;
        var minusTwo = 1;

        for (var i = 2; n >= i; ++i) {
            var curr = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = curr;
        }

        return minusOne;
    }

    public int climbStairsBottomUp(int n) {
        int[] dp = new int[1 + n];

        Array.Fill(dp, 1);

        for (int idx = 2; n >= idx; ++idx) {
            dp[idx] = dp[idx - 1] + dp[idx - 2];
        }


        return dp[n];
    }
}
