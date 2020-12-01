class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int result = words.length;

        for (int idx = 0; words.length > idx; ++idx) {
            if (words[idx].equals(word1)) {
                idx1 = idx;
            } else if (words[idx].equals(word2)) {
                idx2 = idx;
            }

            if (-1 != idx1 && -1 != idx2) {
                result = Math.min(result, Math.abs(idx1 - idx2));
            }
        }

        return result;
    }
}
