public class Solution {
    public int MinDistance(string word1, string word2) {
        int[,] dp = new int[1 + word1.Length, 1 + word2.Length];

        return word1.Length + word2.Length - 2 * lcs(word1, word2, word1.Length, word2.Length, dp);
    }

    public int lcs(String s1, String s2, int m, int n, int[,] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m, n] > 0) {
            return dp[m, n];
        }

        if (s1[m - 1] == s2[n - 1]) {
            dp[m, n] = 1 + lcs(s1, s2, m - 1, n - 1, dp);
        } else {
            dp[m, n] = Math.Max(lcs(s1, s2, m, n - 1, dp), lcs(s1, s2, m - 1, n, dp));
        }

        return dp[m, n];
    }
}
