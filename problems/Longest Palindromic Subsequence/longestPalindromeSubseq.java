class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int start = 0; n > start; ++start) {
            for (int end = start; 0 <= end; --end) {
                if (start == end) {
                    dp[start][end] = 1;
                } else if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 + dp[start - 1][1 + end];
                } else {
                    dp[start][end] = Math.max(dp[start - 1][end], dp[start][1 + end]);
                }
            }
        }

        return dp[n - 1][0];
    }
}
