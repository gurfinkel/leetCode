public class Solution {
    public string ShortestCommonSupersequence(string str1, string str2) {
        int len1 = str1.Length;
        int len2 = str2.Length;
        int[,] dp = new int[1 + len1, 1 + len2];
        StringBuilder sb = new StringBuilder();
        int idx1 = len1;
        int idx2 = len2;

        getShortestCommonSupersequenceLenBottomUp(str1, str2, dp);

        while (0 < idx1 || 0 < idx2) {
            if (0 == idx1) {
                sb.Insert(0, str2[--idx2]);
            } else if (0 == idx2) {
                sb.Insert(0, str1[--idx1]);
            } else if (str1[idx1 - 1] == str2[idx2 - 1]) {
                sb.Insert(0, str2[idx2 - 1]);
                --idx1;
                --idx2;
            } else if (dp[idx1 - 1, idx2] < dp[idx1, idx2 - 1]) {
                sb.Insert(0, str1[--idx1]);
            } else {
                sb.Insert(0, str2[--idx2]);
            }
        }

        return sb.ToString();
    }

    private int getShortestCommonSupersequenceLenBottomUp(string str1, string str2, int[,] dp) {
        int len1 = str1.Length;
        int len2 = str2.Length;

        for (int idx1 = 0; len1 >= idx1; ++idx1) {
            for (int idx2 = 0; len2 >= idx2; ++idx2) {
                if (0 == idx1) {
                    dp[idx1, idx2] = idx2;
                } else if (0 == idx2) {
                    dp[idx1, idx2] = idx1;
                } else if (str1[idx1 - 1] == str2[idx2 - 1]) {
                    dp[idx1, idx2] = 1 + dp[idx1 - 1, idx2 - 1];
                } else {
                    dp[idx1, idx2] = 1 + Math.Min(dp[idx1 - 1, idx2], dp[idx1, idx2 - 1]);
                }
            }
        }

        return dp[len1, len2];
    }
}
