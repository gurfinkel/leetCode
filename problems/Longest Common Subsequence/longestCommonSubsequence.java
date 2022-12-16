class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Time Limit Exceeded
        // text1 = "pmjghexybyrgzczy" text2 = "hafcdqbgncrcbihkd"
        // return getLcsLenRecursive(text1, text2, 0, 0);

        // Accepted
        return getLcsLenBottomUp(text1, text2);

        // Accepted
        // return getLcsLenTopDown(text1, text2, new Integer[text1.length()][text2.length()], 0, 0);
    }

    int getLcsLenBottomUp(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int [2][1 + n2];

        for (int idx1 = 0; n1 > idx1; ++idx1) {
            for (int idx2 = 0; n2 > idx2; ++idx2) {
                if (text1.charAt(idx1) == text2.charAt(idx2)) {
                    dp[(1 + idx1)&1][1 + idx2] = 1 + dp[idx1&1][idx2];
                } else {
                    dp[(1 + idx1)&1][1 + idx2] = Math.max(dp[(1 + idx1)&1][idx2], dp[idx1&1][1 + idx2]);
                }
            }
        }

        return Math.max(dp[0][n2], dp[1][n2]);
    }

    int getLcsLenRecursive(String text1, String text2, int idx1, int idx2) {
        if (text1.length() == idx1 || text2.length() == idx2) {
            return 0;
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return 1 + getLcsLenRecursive(text1, text2, 1 + idx1, 1 + idx2);
        }

        return Math.max(getLcsLenRecursive(text1, text2, idx1, 1 + idx2), getLcsLenRecursive(text1, text2, 1 + idx1, idx2));
    }

    int getLcsLenTopDown(String text1, String text2, Integer[][] dp, int idx1, int idx2) {
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
}
