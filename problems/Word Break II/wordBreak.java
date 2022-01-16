class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();

        dfs(s, wordDict, new ArrayList<String>(), result);

        return result;
    }

    private void dfs(String text, List<String> wordDict, List<String> path, List<String> result) {
        if ((null == text || 0 == text.length()) && 0 < path.size()) {
            result.add(String.join(" ", path));
            return;
        }

        for (String word : wordDict) {
            if (checkPrefix(text, word)) {
                List<String> newPath = new ArrayList<>(path);

                newPath.add(word);
                dfs(text.substring(word.length()), wordDict, newPath, result);
            }
        }
    }

    private boolean checkPrefix(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return false;
        }

        for (int idx = 0; pattern.length() > idx; ++idx) {
            if (text.charAt(idx) != pattern.charAt(idx)) {
                return false;
            }
        }

        return true;
    }
}
