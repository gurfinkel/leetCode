public class Solution {
    public int LongestPalindromeSubseq(string s) {
        int n = s.Length;
        int[,] dp = new int[n, n];
        for(int j = 0; j < n; j++)
        {
             dp[j, j] = 1;
            for(int i = j - 1; i >= 0; i--)
            {
                if(s[i] == s[j])
                    dp[i, j] = dp[i + 1, j - 1] + 2;
                else
                    dp[i, j] = Math.Max(dp[i + 1, j], dp[i, j - 1]);
            }
        }

        return dp[0, n - 1];
    }
}
