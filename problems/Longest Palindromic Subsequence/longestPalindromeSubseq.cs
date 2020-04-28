public class Solution {
    public int LongestPalindromeSubseq(string s) {
        var n = s.Length;
        var dp = new int[n, n];

        for (var right = 0; n > right; ++right) {
            dp[right, right] = 1;

            for (var left = right - 1; 0 <= left; --left) {
                if (s[left] == s[right]) {
                    dp[left, right] = dp[1 + left, right - 1] + 2;
                } else {
                    dp[left, right] = Math.Max(dp[1+left,right],dp[left,right-1]);
                }
            }
        }

        return dp[0, n - 1];
    }
}
