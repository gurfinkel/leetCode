public class Solution {
    public int MinInsertions(string s) {
        return s.Length - getLpsLength(s);
    }

    private int getLpsLength(String s) {
        int n = s.Length;
        int[,] dp = new int[n, n];

        for (int start = n - 1; 0 <= start; --start) {
            for (int end = start; n > end; ++end) {
                if (start == end) {
                    dp[start, end] = 1;
                } else if (s[start] == s[end]) {
                    dp[start, end] = 2 + dp[1 + start, end - 1];
                } else {
                    dp[start, end] = Math.Max(dp[1 + start, end], dp[start, end - 1]);
                }
            }
        }

        return dp[0, n - 1];
    }
}
