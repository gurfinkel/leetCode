public class Solution {
    public int LongestPalindromeSubseq(string s) {
        int[,] dp = new int[s.Length, s.Length];

        return lpsTopDown(s, dp, 0, s.Length - 1);
    }

    private int lpsTopDown(string s, int[,] dp, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (0 == dp[start, end]) {
            if (s[start] == s[end]) {
                dp[start, end] = 2 + lpsTopDown(s, dp, 1 + start, end - 1);
            } else {
                int lpsLeft = lpsTopDown(s, dp, 1 + start, end);
                int lpsRight = lpsTopDown(s, dp, start, end - 1);

                dp[start, end] = Math.Max(lpsLeft, lpsRight);
            }
        }

        return dp[start, end];
    }
}
