public class Solution {
    public string LongestPalindrome(string s) {
        int n = s.Length;
        bool[,] dp = new bool[n, n];
        string lps = "";

        for (int start = n - 1; 0 <= start; --start) {
            for (int end = start; n > end; ++end) {
                if (s[start] == s[end]) {
                    if (2 >= 1 + end - start || dp[1 + start, end - 1]) {
                        dp[start, end] = true;

                        if (lps.Length < 1 + end - start) {
                            lps = s.Substring(start, 1 + end - start);
                        }
                    }
                }
            }
        }

        return lps;
    }
}
