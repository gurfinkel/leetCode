class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        HashMap<Character, List<int[]>> store = new HashMap<>();

        for (int idx = 0; words.length > idx; ++idx) {
            if (!store.containsKey(words[idx].charAt(0))) {
                store.put(words[idx].charAt(0), new ArrayList());
            }
            store.get(words[idx].charAt(0)).add(new int[]{idx, 0});
        }

        for (char token : s.toCharArray()) {
            if (store.containsKey(token)) {
                List<int[]> items = new ArrayList(store.get(token));
                store.get(token).clear();

                for (int[] wordIdxAndPosition : items) {
                    int wordIdx = wordIdxAndPosition[0];
                    int position = 1 + wordIdxAndPosition[1];

                    if (words[wordIdx].length() == position) {
                        ++result;
                    } else {
                        if (!store.containsKey(words[wordIdx].charAt(position))) {
                            store.put(words[wordIdx].charAt(position), new ArrayList());
                        }
                        store.get(words[wordIdx].charAt(position)).add(new int[]{wordIdx, position});
                    }
                }
            }
        }

        return result;
    }
}
