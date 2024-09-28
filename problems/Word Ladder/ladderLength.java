class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> edgeWordToWordsMap = new HashMap<>();
        Queue<String> bfs = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int level = 1;

        for (String word : wordList) {
            for (int idx = 0; word.length() > idx; ++idx) {
                String edgeWord = word.substring(0, idx) + '$' + word.substring(1 + idx);

                if (!edgeWordToWordsMap.containsKey(edgeWord)) {
                    edgeWordToWordsMap.put(edgeWord, new ArrayList<>());
                }

                edgeWordToWordsMap.get(edgeWord).add(word);
            }
        }

        bfs.add(beginWord);
        visited.add(beginWord);

        while (!bfs.isEmpty()) {
            for (int count = bfs.size(); 0 < count; --count) {
                String word = bfs.poll();
                
                for (int idx = 0; word.length() > idx; ++idx) {
                    String edgeWord = word.substring(0, idx) + '$' + word.substring(1 + idx);

                    if (edgeWordToWordsMap.containsKey(edgeWord)) {
                        List<String> nextWords = edgeWordToWordsMap.get(edgeWord);

                        for (String nextWord : nextWords) {
                            if (endWord.equals(nextWord)) {
                                return 1 + level;
                            } else if (!visited.contains(nextWord)) {
                                bfs.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                }
            }

            ++level;
        }

        return 0;
    }
}
