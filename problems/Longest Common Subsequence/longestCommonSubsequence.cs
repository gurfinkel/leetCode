public class Solution {
    public int LongestCommonSubsequence(string text1, string text2) {
        return getLcsLenBottomUp(text1, text2);
    }

    private int getLcsLenBottomUp(string text1, string text2) {
        int len1 = text1.Length;
        int len2 = text2.Length;
        int[,] dp = new int[2, 1 + len2];
        int result = 0;

        for (int idx1 = 1; len1 >= idx1; ++idx1) {
            for (int idx2 = 1; len2 >= idx2; ++idx2) {
                if (text1[idx1 - 1] == text2[idx2 - 1]) {
                    dp[(idx1&1), idx2] = 1 + dp[((idx1 - 1)&1), idx2 - 1];
                } else {
                    dp[(idx1&1), idx2] = Math.Max(dp[((idx1 - 1)&1), idx2], dp[(idx1&1), idx2 - 1]);
                }

                result = Math.Max(result, dp[(idx1&1), idx2]);
            }
        }

        return result;
    }
}
