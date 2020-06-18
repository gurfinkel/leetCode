class Solution {
    public int minCut(String s) {
        int n = s.length();
        Boolean[][] isPalindromeDp = new Boolean[n][n];
        Integer[][] minCutsDp = new Integer[n][n];

        return getMinCutsTopDown(s, minCutsDp, isPalindromeDp, 0, s.length() - 1);
    }

    private int getMinCutsTopDown(String s, Integer[][] minCutsDp, Boolean[][] isPalindromeDp, int start, int end) {
        if (start >= end || isPalindrome(s, isPalindromeDp, start, end)) {
            return 0;
        }

        if (null == minCutsDp[start][end]) {
            int minCuts = end - start;

            for (int idx = start; end >= idx; ++idx) {
                if (isPalindrome(s, isPalindromeDp, start, idx)) {
                    minCuts = Math.min(minCuts, 1 + getMinCutsTopDown(s, minCutsDp, isPalindromeDp, 1 + idx, end));
                }
            }

            minCutsDp[start][end] = minCuts;
        }

        return minCutsDp[start][end];
    }

    private boolean isPalindrome(String s, Boolean[][] dp, int start, int end) {
        if (null == dp[start][end]) {
            int i = start;
            int j = end;

            dp[start][end] = true;

            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) {
                    dp[start][end] = false;
                    break;
                }

                if (i < j && null != dp[i][j]) {
                    dp[start][end] = dp[i][j];
                    break;
                }
            }
        }

        return dp[start][end];
    }
}