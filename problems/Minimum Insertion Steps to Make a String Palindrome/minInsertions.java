class Solution {
    public int minInsertions(String s) {
        return s.length() - getLpsLength(s);
    }

    private int getLpsLength(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];

        return getLpsLengthTopDown(s, dp, 0, n - 1);
    }

    private int getLpsLengthTopDown(String s, Integer[][] dp, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (null == dp[start][end]) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = 2 + getLpsLengthTopDown(s, dp, 1 + start, end - 1);
            } else {
                dp[start][end] = Math.max(getLpsLengthTopDown(s, dp, 1 + start, end), getLpsLengthTopDown(s, dp, start, end - 1));
            }
        }

        return dp[start][end];
    }
}
