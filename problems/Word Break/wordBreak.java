class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakTopDown(s, new HashSet<String>(wordDict), new Boolean[s.length()], 0);
    }

    private boolean wordBreakTopDown(String s, Set<String> store, Boolean[] memo, int start) {
        if (start == s.length()) {
            return true;
        }

        if (null == memo[start]) {
            for (int end = 1 + start; s.length() >= end; ++end) {
                if (store.contains(s.substring(start, end)) && wordBreakTopDown(s, store, memo, end)) {
                    memo[start] = true;

                    return memo[start];
                }
            }

            memo[start] = false;
        }

        return memo[start];
    }
}
