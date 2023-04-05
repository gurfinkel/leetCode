class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int result = wordsDict.length;
        int idx1 = -1;
        int idx2 = -1;
        Boolean isFirstTurn = true;

        for (int idx = 0; wordsDict.length > idx; ++idx) {
            if (word1.equals(word2)) {
                if (wordsDict[idx].equals(word1)) {
                    if (isFirstTurn) {
                        idx1 = idx;
                        isFirstTurn = false;
                    } else {
                        idx2 = idx;
                        isFirstTurn = true;
                    }
                }
            } else {
                if (wordsDict[idx].equals(word1)) {
                    idx1 = idx;
                } else if (wordsDict[idx].equals(word2)) {
                    idx2 = idx;
                }
            }

            if (-1 != idx1 && -1 != idx2) {
                result = Math.min(result, Math.abs(idx1 - idx2));
            }
        }

        return result;
    }
}
