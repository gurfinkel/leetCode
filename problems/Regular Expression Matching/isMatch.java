class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchBottomUp(s, p);
    }

    boolean isMatchBottomUp(String text, String pattern) {
        int tLen = text.length();
        int pLen = pattern.length();
        boolean[][] dp = new boolean[1 + tLen][1 + pLen];

        dp[tLen][pLen] = true;

        for (int tIdx = tLen; 0 <= tIdx; --tIdx) {
            for (int pIdx = pLen - 1; 0 <= pIdx; --pIdx) {
                boolean currMatch = tLen > tIdx &&
                                    (text.charAt(tIdx) == pattern.charAt(pIdx) ||
                                     '.' == pattern.charAt(pIdx));
                if (pLen > 1 + pIdx && '*' == pattern.charAt(1 + pIdx)) {
                    dp[tIdx][pIdx] = dp[tIdx][2 + pIdx] || (currMatch && dp[1 + tIdx][pIdx]);
                } else {
                    dp[tIdx][pIdx] = currMatch && dp[1 + tIdx][1 + pIdx];
                }
            }
        }

        return dp[0][0];
    }
}
