class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> store = new HashMap<>();
        Queue<String> bfs = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int level = 1;

        for (String word : wordList) {
            for (int idx = 0; word.length() > idx; ++idx) {
                String edgeWord = word.substring(0, idx) + '$' + word.substring(1 + idx);

                if (!store.containsKey(edgeWord)) {
                    store.put(edgeWord, new ArrayList<>());
                }
                store.get(edgeWord).add(word);
            }
        }

        bfs.add(beginWord);
        visited.add(beginWord);

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int count = 0; size > count; ++count) {
                String word = bfs.poll();

                for (int idx = 0; word.length() > idx; ++idx) {
                    String edgeWord = word.substring(0, idx) + '$' + word.substring(1 + idx);
                    if (!store.containsKey(edgeWord)) {
                        continue;
                    }
                    List<String> adjacentWords = store.get(edgeWord);

                    for (String adjacentWord : adjacentWords) {
                        if (endWord.equals(adjacentWord)) {
                            return 1 + level;
                        }
                        if (!visited.contains(adjacentWord)) {
                            bfs.add(adjacentWord);
                            visited.add(adjacentWord);
                        }
                    }
                }
            }

            ++level;
        }

        return 0;
    }
}
