class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];

        return minDistanceTopDown(word1, word2, dp, 0, 0);
    }

    private int minDistanceTopDown(String word1, String word2, Integer[][] dp, int idx1, int idx2) {
        if (word1.length() == idx1) {
            return word2.length() - idx2;
        }

        if (word2.length() == idx2) {
            return word1.length() - idx1;
        }

        if (null == dp[idx1][idx2]) {
            if (word1.charAt(idx1) == word2.charAt(idx2)) {
                dp[idx1][idx2] = minDistanceTopDown(word1, word2, dp, 1 + idx1, 1 + idx2);
            } else {
                int del = 1 + minDistanceTopDown(word1, word2, dp, 1 + idx1, idx2);
                int ins = 1 + minDistanceTopDown(word1, word2, dp, idx1, 1 + idx2);
                int rep = 1 + minDistanceTopDown(word1, word2, dp, 1 + idx1, 1 + idx2);

                dp[idx1][idx2] = Math.min(del, Math.min(ins, rep));
            }
        }

        return dp[idx1][idx2];
    }

    private int minDistanceRecursive(String word1, String word2, int idx1, int idx2) {
        if (word1.length() == idx1) {
            return word2.length() - idx2;
        }

        if (word2.length() == idx2) {
            return word1.length() - idx1;
        }

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return minDistanceRecursive(word1, word2, 1 + idx1, 1 + idx2);
        }

        int del = 1 + minDistanceRecursive(word1, word2, 1 + idx1, idx2);
        int ins = 1 + minDistanceRecursive(word1, word2, idx1, 1 + idx2);
        int rep = 1 + minDistanceRecursive(word1, word2, 1 + idx1, 1 + idx2);

        return Math.min(del, Math.min(ins, rep));
    }
}
