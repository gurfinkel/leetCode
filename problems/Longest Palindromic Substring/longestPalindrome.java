class Solution {
    public String longestPalindrome(String s) {
        return longestPalindromeExpandAroundCenter(s);
        // return longestPalindromeDp(s);
    }

    String longestPalindromeExpandAroundCenter(String s) {
        int left = 0;
        int right = 0;

        for (int idx = 0; s.length() > idx; ++idx) {
            int oneCenterPalindromeLen = getPalindromeLength(s, idx, true);
            int twoCentersPalindromeLen = getPalindromeLength(s, idx, false);
            int maxLength = Math.max(oneCenterPalindromeLen, twoCentersPalindromeLen);

            if (1 + right - left < maxLength) {
                left = idx - (maxLength - 1) / 2;
                right = idx + maxLength / 2;
            }
        }

        return s.substring(left, 1 + right);
    }

    int getPalindromeLength(String s, int idx, boolean hasOneCenter) {
        int left = idx;
        int right = hasOneCenter ? idx : 1 + idx;

        while (0 <= left && s.length() > right && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        return right - left - 1;
    }

    String longestPalindromeDp(String s) {
        if (null == s || 0 == s.length()) {
            return "";
        }

        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        StringBuilder lps = new StringBuilder();

        lps.append(s.charAt(0));
        lpsTopDown(s, dp, 0, n - 1, lps);

        return lps.toString();
    }

    int lpsTopDown(String s, Integer[][] dp, int start, int end, StringBuilder lps) {
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
