class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int start = n - 1; 0 <= start; --start) {
            for (int end = start; n > end; ++end) {
                if (start == end ||
                   (s.charAt(start) == s.charAt(end) &&
                   (1 == end - start || dp[1 + start][end - 1]))) {
                    dp[start][end] = true;
                    ++count;
                }
            }
        }

        return count;
    }
}