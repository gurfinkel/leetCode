class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];

        return getLcsLenTopDown(text1, text2, dp, 0, 0);
    }

    private int getLcsLenTopDown(String text1, String text2, Integer[][] dp, int idx1, int idx2) {
        if (text1.length() == idx1 || text2.length() == idx2) {
            return 0;
        }

        if (null == dp[idx1][idx2]) {
            if (text1.charAt(idx1) == text2.charAt(idx2)) {
                dp[idx1][idx2] = 1 + getLcsLenTopDown(text1, text2, dp, 1 + idx1, 1 + idx2);
            } else {
                dp[idx1][idx2] = Math.max(getLcsLenTopDown(text1, text2, dp, idx1, 1 + idx2), getLcsLenTopDown(text1, text2, dp, 1 + idx1, idx2));
            }
        }

        return dp[idx1][idx2];
    }

    private int getLcsLenRecursive(String text1, String text2, int idx1, int idx2) {
        if (text1.length() == idx1 || text2.length() == idx2) {
            return 0;
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return 1 + getLcsLenRecursive(text1, text2, 1 + idx1, 1 + idx2);
        }

        return Math.max(getLcsLenRecursive(text1, text2, idx1, 1 + idx2), getLcsLenRecursive(text1, text2, 1 + idx1, idx2));
    }
}
