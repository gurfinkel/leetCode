class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 2; 0 <= i; --i) {
            for (int j = i + 1; s.length() > j; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return k >= dp[0][s.length() - 1];
    }
}
