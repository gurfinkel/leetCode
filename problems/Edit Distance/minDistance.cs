public class Solution {
    public int MinDistance(string word1, string word2) {
        return minDistanceBottomUp(word1, word2);
    }

    private int minDistanceBottomUp(string word1, string word2) {
        int len1 = word1.Length;
        int len2 = word2.Length;
        int[,] dp = new int[1 + len1, 1 + len2];

        for (int idx1 = 0; len1 >= idx1; ++idx1) {
            for (int idx2 = 0; len2 >= idx2; ++idx2) {
                if (0 == idx1) {
                    dp[0, idx2] = idx2;
                } else if (0 == idx2) {
                    dp[idx1, 0] = idx1;
                } else if (word1[idx1 - 1] == word2[idx2 - 1]) {
                    dp[idx1, idx2] = dp[idx1 - 1, idx2 - 1];
                } else {
                    int delete = dp[idx1 - 1, idx2];
                    int insert = dp[idx1, idx2 - 1];
                    int replace = dp[idx1 - 1, idx2 - 1];

                    dp[idx1, idx2] = 1 + Math.Min(delete, Math.Min(insert, replace));
                }
            }
        }

        return dp[len1, len2];
    }
}
