public class Solution {
    public string LongestPalindrome(string s) {
        return longestPalindromeBottomUp(s);
    }

    private string longestPalindromeBottomUp(string s) {
        int n = s.Length;
        bool[,] dp = new bool[n, n];
        string lp = "";

        for (int left = n - 1; 0 <= left; --left) {
            for (int right = left; n > right; ++right) {
                if (s[left] == s[right]) {
                    if (2 >= 1 + right - left || dp[1 + left, right - 1]) {
                        dp[left, right] = true;

                        if (lp.Length < 1 + right - left) {
                            lp = s.Substring(left, 1 + right - left);
                        }
                    }
                }
            }
        }

        return lp;
    }
}
