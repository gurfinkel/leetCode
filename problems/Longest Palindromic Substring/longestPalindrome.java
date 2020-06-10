class Solution {
    public String longestPalindrome(String s) {
        if (null == s || 0 == s.length()) {
            return "";
        }

        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        StringBuilder lps = new StringBuilder();

        lps.append(s.charAt(0));
        lpsTopDown(s, dp, 0, n - 1, lps);

        // System.out.println("lps: " + lpsTopDown(s, dp, 0, n - 1, lps));

        return lps.toString();
    }

    private int lpsTopDown(String s, Integer[][] dp, int start, int end, StringBuilder lps) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (null == dp[start][end]) {
            if (s.charAt(start) == s.charAt(end)) {
                int remainingLen = end - start - 1;

                if (remainingLen == lpsTopDown(s, dp, 1 + start, end - 1, lps)) {
                    dp[start][end] = 2 + remainingLen;

                    if (dp[start][end] > lps.length()) {
                        lps.setLength(0);
                        lps.append(s.substring(start, 1 + end));
                    }

                    return dp[start][end];
                }
            }

            int left = lpsTopDown(s, dp, 1 + start, end, lps);
            int right = lpsTopDown(s, dp, start, end - 1, lps);

            dp[start][end] = Math.max(left, right);
        }

        return dp[start][end];
    }
}
