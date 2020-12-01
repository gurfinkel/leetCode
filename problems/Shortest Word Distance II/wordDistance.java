class WordDistance {
    private HashMap<String, List<Integer>> _store = new HashMap<>();

    public WordDistance(String[] words) {
        for (int idx = 0; words.length > idx; ++idx) {
            if (!_store.containsKey(words[idx])) {
                _store.put(words[idx], new ArrayList<>());
            }

            _store.get(words[idx]).add(idx);
        }
    }

    public int shortest(String word1, String word2) {
        int result = Integer.MAX_VALUE;
        List<Integer> loc1 = _store.get(word1);
        List<Integer> loc2 = _store.get(word2);
        int idx1 = 0;
        int idx2 = 0;

        while (loc1.size() > idx1 && loc2.size() > idx2) {
            result = Math.min(result, Math.abs(loc1.get(idx1) - loc2.get(idx2)));

            if (loc1.get(idx1) < loc2.get(idx2)) {
                ++idx1;
            } else {
                ++idx2;
            }
        }

        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
