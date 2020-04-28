public class Solution {
    public int LongestCommonSubsequence(string text1, string text2) {
        if (string.IsNullOrEmpty(text1) || string.IsNullOrEmpty(text2)) {
            return 0;
        }

        var l1 = text1.Length;
        var l2 = text2.Length;
        var dp = new int[1 + l1, 1 + l2];

        for (var i = 1; l1 >= i; ++i) {
            for (var j = 1; l2 >= j; ++j) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i, j] = 1 + dp[i - 1, j - 1];
                } else {
                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
                }
            }
        }

        return dp[l1, l2];
    }
}
