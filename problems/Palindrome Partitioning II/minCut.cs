public class Solution {
    public int MinCut(string s) {
        bool[,] isPalindromic = getIsPalindromicDp(s);

        return getMinCuts(s, isPalindromic);
    }

    private int getMinCuts(string s, bool[,] isPalindromicDp) {
        int n = s.Length;
        int[] dp = new int[n];

        for (int start = n - 1; 0 <= start; --start) {
            int minCuts = n;
            for (int end = n - 1; start <= end; --end) {
                if (isPalindromicDp[start, end]) {
                    minCuts = (n - 1 == end ? 0 : Math.Min(minCuts, 1 + dp[1 + end]));
                }
            }
            dp[start] = minCuts;
        }

        return dp[0];
    }

    private bool[,] getIsPalindromicDp(string s) {
        int n = s.Length;
        bool[,] dp = new bool[n, n];

        for (int start = n - 1; 0 <= start; --start) {
            for (int end = start; n > end; ++end) {
                if (s[start] == s[end] && (2 >= 1 + end - start || dp[1 + start, end - 1])) {
                    dp[start, end] = true;
                }
            }
        }

        return dp;
    }
}
